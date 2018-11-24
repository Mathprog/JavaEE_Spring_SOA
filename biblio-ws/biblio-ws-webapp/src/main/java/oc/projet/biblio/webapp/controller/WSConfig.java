package oc.projet.biblio.webapp.controller;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.xml.xsd.XsdSchemaCollection;
import org.springframework.xml.xsd.commons.CommonsXsdSchemaCollection;

@EnableWs
@Configuration
public class WSConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/soapws/*");
    }

    @Bean(name = "usagers")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema usagersSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("UsagersPort");
        wsdl11Definition.setLocationUri("/soapws");
        wsdl11Definition.setTargetNamespace("http://biblio.io/api/biblio-web-service");
        wsdl11Definition.setSchema(usagersSchema);
        return wsdl11Definition;
    }


    @Bean(name = "ouvrages")
    public DefaultWsdl11Definition defaultWsdl11lDefinition(XsdSchemaCollection ouvragesSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("OuvragesPort");
        wsdl11Definition.setLocationUri("/soapws");
        wsdl11Definition.setTargetNamespace("http://biblio.io/api/biblio-web-service");
        wsdl11Definition.setSchemaCollection(ouvragesSchema);
        return wsdl11Definition;
    }

    @Bean(name = "exemplaires")
    public DefaultWsdl11Definition defaultWsdl11llDefinition(XsdSchemaCollection exemplairesSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ExemplairesPort");
        wsdl11Definition.setLocationUri("/soapws");
        wsdl11Definition.setTargetNamespace("http://biblio.io/api/biblio-web-service");
        wsdl11Definition.setSchemaCollection(exemplairesSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema usagersSchema() {
        return new SimpleXsdSchema(new ClassPathResource("usagers.xsd"));
    }

    @Bean
    public XsdSchemaCollection ouvragesSchema() {
        CommonsXsdSchemaCollection xsds = new CommonsXsdSchemaCollection(
                new ClassPathResource("WS-XSD/ouvrage.xsd"),
                new ClassPathResource("WS-XSD/ouvrage-methods.xsd"));
        xsds.setInline(true);
        return xsds;
    }

    @Bean
    public XsdSchemaCollection exemplairesSchema() {
        CommonsXsdSchemaCollection xsds = new CommonsXsdSchemaCollection(
                new ClassPathResource("WS-XSD/ouvrage.xsd"),
                new ClassPathResource("WS-XSD/exemplaire.xsd"),
                new ClassPathResource("WS-XSD/exemplaire-method.xsd"));
        xsds.setInline(true);
        return xsds;

    }
}
