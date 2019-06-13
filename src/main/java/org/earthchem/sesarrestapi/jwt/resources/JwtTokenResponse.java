package org.earthchem.sesarrestapi.jwt.resources;

import java.io.Serializable;

public class JwtTokenResponse implements Serializable {

  private static final long serialVersionUID = 8317676219297719109L;

  private final String token;
//  { 
//   "token":"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJpbjI4bWludXRlcyIsImV4cCI6MTU2MTA0NzE1MSwiaWF0IjoxNTYwNDQyMzUxfQ.wxf5J0wIZY4uPS2oDreelAUU8E-nbet16ua6fVIFbhxW1tkdshMAMXHp4qZr53QdHle_PmqbT2TctVGz6WCXzA"
//  }

    public JwtTokenResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}