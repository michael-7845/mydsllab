# mydsl
Repository for Michael Yu Domain Specific Language script.

* requirement
1. groovy, 2.4.12+   

* groovy grape setting
1. login https://repository.hybris.com/webapp  
2. select "set me up", search "ivy", click "typesafe-ivy", do the following:    
> Generate Ivy Settings  
> tool:ivy  
> input your account and password   
> libs-repository (use ibiblio resolver): hybris-repository    
> libs repository layout (maven 2 compatible): ivy-default    
> libs resolver name: hybris  
> Generate Settings  
3. in generated page, Download Snippet to edit grapeConfig.xml.   
refer to script/sample/grapeConfig.xml  
4. put grapeConfig.xml to groovy home.   
> windows: C:\Users\yourAccount\.groovy  

* edit yaml configuration  
1. select yourTenant  
2. get your access token, refer to https://wiki.hybris.com/pages/viewpage.action?pageId=348641708
3. edit your mt.yml from script/sample/mt.yml
> set tenant = yourTenant  
4. edit your mt-yourTenant.yml from script/sample/mt-yourTenant.yml  
> rename mt-yourTenant.yml, e.g. mt-caastestqa.yml   
> set env (test: {name: test, postfix: -test}, stage: {name: stage, postfix: -stage}, prod: {name: prod, postfix: ''})   
> set token (use access tokens from step 2)   
> if you want, set session (for anonymous header customer-session-id, or use default value in template)   
> if you want, set version   
> not use for now, so not set: audit_log, register   
> not set resource, sample MyDSL script will refresh it   

* run setup.groovy  
run script/sample/setup.groovy step by step.  
then you can run your MyDSL script.  
