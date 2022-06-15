package utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class CookieManager {
    
    //명시한 이름, 값, 유지기간 조건으로 새로운 쿠키 생성
    public static void makeCookie(HttpServletResponse response, String cName, String cValue, int cTime) {
        Cookie cookie = new Cookie(cName, cValue);        //쿠키 생성
        cookie.setPath("/");                             //경로 설정
        cookie.setMaxAge(cTime);                        //유지 기간 설정
        response.addCookie(cookie);                        //응답 객체에 추가
    }
    
    //명시한 이름의 쿠키를 찾아 그 값을 반환함.
    public static String readCookie(HttpServletRequest request, String cName) {
        String cookieValue = "";
        
        Cookie[] cookies = request.getCookies();    //클라이언트가 보내온 쿠키 목록을 받아서 
        if(cookies != null) {
            for(Cookie c : cookies) {
                String cookieName = c.getName();    
                if(cookieName.equals(cName)) {        //그중 cName과 이름이 같은 쿠키가 있따면
                   cookieValue = c.getValue();        //반환 값 갱신
                }
            }
        }
        
        return cookieValue;                            //그 값을 반환함.
    }
    
    //명시한 이름의 쿠키를 삭제함.
    public static void deleteCookie(HttpServletResponse response, String cName) {
        makeCookie(response, cName, "", 0);            //쿠키 생성 비어있는 문자열로, 유지 기간은 0으로 부여함.
    }
 
}
 