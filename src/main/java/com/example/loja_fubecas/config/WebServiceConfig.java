package com.example.loja_fubecas.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    // Define a rota do contrato: /ws/fubecas.wsdl
    @Bean(name = "fubecas")
    public DefaultWsdl11Definition fubecasWsdl(XsdSchema fubecasSchema) {
        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
        wsdl.setPortTypeName("FubecasPort");
        wsdl.setLocationUri("/ws");
        wsdl.setTargetNamespace("http://lojadefubecas.com/fubecas");
        wsdl.setSchema(fubecasSchema);
        return wsdl;
    }

    @Bean
    public XsdSchema fubecasSchema() {
        return new SimpleXsdSchema(new ClassPathResource("fubecas.xsd"));
    }
}