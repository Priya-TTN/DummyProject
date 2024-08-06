package com.mactok.com.mactok.VersioningHandler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class VersionV1 {

   @GetMapping("/v1/person")
    public Person VersionV1Handler(){
        return new Person("Jon Ebram");
    }

    @GetMapping("/v2/person")
    public PersonV2 VersionV2Handler(){
        return new PersonV2(new Name("John", "abram"));
    }

    @GetMapping(path = "/person", params = "version=1.0")
    public Person VersionV1HandlerRequestParameter(){
        return new Person("Jon Ebram");
    }

    @GetMapping(path = "/person", params = "version=2.0")
    public PersonV2 VersionV2HandlerRequestParameter(){
        return new PersonV2(new Name("John", "abram"));
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public PersonV2 VersionV2HandlerRequestParameterRequestHeader(){
        return new PersonV2(new Name("John", "abram"));
    }

    @GetMapping(path = "/person/header", headers="X-API-VERSION=2")
    public PersonV2 VersionV2HandlerRequestHeader(){
        return new PersonV2(new Name("John", "abram"));
    }

    @GetMapping(path = "/person/accept", produces = "application/mactok.app-v1+json")
    public PersonV2 VersionV2HandlerRequestParameterAcceptHeader(){
        return new PersonV2(new Name("John", "abram"));
    }


}
