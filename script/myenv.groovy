@GrabConfig(systemClassLoader=true)
@Grab(group='ch.qos.logback', module='logback-classic', version='1.1.7')
@Grab(group='ch.qos.logback', module='logback-core', version='1.1.7')
@Grab(group='com.hybris.caas', module='mydsl', version='0.0.1')
@GrabExclude('org.codehaus.groovy:groovy-xml')
import mooncake.smoke.mt.dsl.MyDSL

MyDSL.make {
    // step1> retrieve environment information, to generate mt_tenant.yml
//    env.refresh_env()
    // step2> edit mt_tenant.yml, select resource.candidate for you.
    // step3> copy content into mt_<your tenant>.yml.
    // step4> refresh according to current environment information, to generate mt_tenant.yml.
    env.refresh_env_by_yaml()
    // step5> copy mt_tenant content to mt_<your tenant>.yml.
    // now, environment yaml is done!

    // check or list environment
//    env.check_env()
    // check or list environment in yaml
//    println yaml.all.resource.candidate
//    env.check_env_by_yaml()
}