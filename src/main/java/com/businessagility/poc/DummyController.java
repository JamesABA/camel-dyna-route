package com.businessagility.poc;

import org.apache.camel.model.RoutesDefinition;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * Created by JamesAyling on 08/03/2017.

 * This bean receives a route as an XML String, builds a RouteDefinition from it
 * then adds it to the CamelContext
 */
public class DummyController {

    private SpringCamelContext context;

    @Autowired
    public void setContext(SpringCamelContext context) {
        this.context = context;
    }

    public void setNewRoute(String routexml) throws Exception {

        InputStream is = new ByteArrayInputStream(routexml.getBytes(StandardCharsets.UTF_8));

        RoutesDefinition routes = context.loadRoutesDefinition(is);
        context.addRouteDefinitions(routes.getRoutes());
    }

}
