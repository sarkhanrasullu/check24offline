package de.c24.finacc.klt.rest;

import static org.junit.Assert.assertEquals;

import de.c24.finacc.klt.dto.RestResponseDTO;
import org.junit.Test;

import java.util.Map;

/**
 * tests a little bit RestService
 * @author Jörn Schricker
 */
public class RestServiceTest {

    /**
     * testTooYoung
     */
    @Test
    public void testTooYoung() {
        RestService restService = new RestService();
        RestResponseDTO result = restService.validateAge(1);//too young

        assertEquals(1L, (long)result.getErrorCode());
    }

    /**
     * testTooOld
     */
    @Test
    public void testTooOld() {
        RestService restService = new RestService();
        RestResponseDTO result = restService.validateAge(70);//too young

        assertEquals(2L, (long)result.getErrorCode());
    }

    /**
     * testFunny
     */
    @Test
    public void testFunny() {
        RestService restService = new RestService();
        RestResponseDTO result = restService.validateAge(19);//too young

        assertEquals(null, result.getErrorCode());
        assertEquals("funny", result.getMsg());
    }

    /**
     * testOK
     */
    @Test
    public void testOK() {
        RestService restService = new RestService();
        RestResponseDTO result = restService.validateAge(20);//OK

        assertEquals(null, result.getErrorCode());
        assertEquals("OK", result.getMsg());
    }
}
