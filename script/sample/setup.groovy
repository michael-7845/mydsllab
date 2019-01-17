@GrabConfig(systemClassLoader=true)
@Grab(group='ch.qos.logback', module='logback-classic', version='1.1.7')
@Grab(group='ch.qos.logback', module='logback-core', version='1.1.7')
@Grab(group='com.hybris.caas', module='mydsl', version='0.0.1')
@GrabExclude('org.codehaus.groovy:groovy-xml')
import mooncake.smoke.mt.dsl.MyDSL

// note: it is mt_tenant.yml, not mt_yourTenant.yml.
MyDSL.make('step1> retrieve environment information, to generate mt_tenant.yml.', true) {
    refresh_env()
}

// candidate suggestion, or may fail MyDSL running due to no test data:
// >= 1 export job name, >=1 settle job name
// >= 2 cancel reasons, >= 2 return reasons, >= 2 mispick reasons
// >= 3 location id
// >= 1 experience id
MyDSL.make('step2> edit mt_tenant.yml: select resource.candidate for you, keeping what you want, removing what you don\'t want.', false) {}

MyDSL.make('step3> copy mt_tenant.yml content into mt_<yourTenant>.yml.', false) {}

MyDSL.make('step4> refresh according to current environment information, to generate mt_tenant.yml.', false) {
    refresh_env_by_yaml()
}

MyDSL.make('step5> copy new mt_tenant content to mt_<yourTenant>.yml. now, environment yaml is done!', false) {}

MyDSL.make('step6> if you want, you can check or list environment now.', false) {
    println yaml.all.resource.candidate
    check_env_by_yaml()
}

MyDSL.make('step7> you can run your MyDSL script now. try some script in script/sample.', false) {}