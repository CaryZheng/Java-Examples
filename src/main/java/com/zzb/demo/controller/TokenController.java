package com.zzb.demo.controller;

import com.zzb.demo.response.ResponseWrapper;
import com.zzb.demo.utils.TokenUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/token")
public class TokenController {

    /**
     * 生成Token
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<ResponseWrapper> createToken() {
        String token = TokenUtils.createToken();

        return ResponseWrapper.successResponse(token);
    }

    /**
     * 验证Token
     * @param params
     * @return
     */
    @PostMapping("/verify")
    public ResponseEntity<ResponseWrapper> verifyToken(@RequestBody Map<String,Object> params) {
        String token = (String) params.get("token");
        String userId = TokenUtils.verifyToken(token);

        return ResponseWrapper.successResponse(userId);
    }
}
