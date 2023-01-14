package model.service;

import java.util.Base64;

/**
 * 패스워드의 암호화와 복호화 지원하는 클래스
 */
public class EncDecService {
    public static String encrypt(String str) {
        // Base64 인코딩 방식을 적용해서 문자열에 대한 암호화 처리
        String encStr = Base64.getEncoder().encodeToString(str.getBytes());
        return encStr;
    }

    public static String decrypt(String str) {
        // Base64로 암호화된 문자열의 복호화를 처리
        byte[] byteStr = Base64.getDecoder().decode(str);
        return new String(byteStr); // byte 타입 배열 값을 String 으로 리턴
    }
}
