package com.apartment.gateway.filter;

import org.apache.commons.codec.binary.Base64;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.apartment.gateway.model.AuthResponse;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Configuration
public class GatewayFilter extends ZuulFilter {

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		
		RequestContext ctx = RequestContext.getCurrentContext();

		if (ctx.getRequest().getRequestURL().indexOf("user") > 0)
			ctx.addZuulRequestHeader("Authorization", "Bearer " + getOAuthToken("userclient:usersecret"));
		else if (ctx.getRequest().getRequestURL().indexOf("unit") > 0)
			ctx.addZuulRequestHeader("Authorization", "Bearer " + getOAuthToken("unitclient:unitsecret"));
		else if (ctx.getRequest().getRequestURL().indexOf("rule") > 0)
			ctx.addZuulRequestHeader("Authorization", "Bearer " + getOAuthToken("ruleclient:rulesecret"));

		return null;
	}

	private String getOAuthToken(String credental) {

		byte[] plainCredsBytes = credental.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);

		String authUri = "http://localhost:7777/oauth/token";
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.add("Authorization", "Basic " + base64Creds);

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("grant_type", "client_credentials");
		map.add("scope", "resource-server-write");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		ResponseEntity<AuthResponse> response = new RestTemplate().postForEntity(authUri, request, AuthResponse.class);
		String oathToken = (String) response.getBody().getAccess_token();

		return oathToken;
	}
}
