package com.gfg.zerocode.rest;

import org.jsmart.zerocode.core.domain.Scenario;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(ZeroCodeUnitRunner.class)
@TargetEnv("rest_api.properties")
public class GeekUserEndpointIT {

    @Test
    @Scenario("rest/geek_user_create_test.json")
    public void test_geekuser_creation_endpoint() {
    }

}
