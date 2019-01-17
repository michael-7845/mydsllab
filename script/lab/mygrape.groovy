package script
@GrabConfig(systemClassLoader=true)
@Grapes([@Grab(group = 'com.google.guava', module = 'guava', version = '27.0-jre')])
import com.google.common.math.BigIntegerMath
import com.google.common.math.IntMath

println IntMath.MAX_SIGNED_POWER_OF_TWO
//@Grapes([
//        @Grab(group='com.hybris.caas', module='mydsl', version='0.0.1'),
//        @GrabExclude('org.codehaus.groovy:groovy-xml'),
//        @Grab(group = 'ch.qos.logback', module = 'logback-classic', version = '1.1.7'),
//        @Grab(group = 'ch.qos.logback', module = 'logback-core', version = '1.1.7')
//])
//import mooncake.smoke.utils.MyProperty
//
//MyProperty.properties.each {
//    println it
//}