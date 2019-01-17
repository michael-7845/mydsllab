package script
@GrabConfig(systemClassLoader=true)
@Grab(group='ch.qos.logback', module='logback-classic', version='1.1.7')
@Grab(group='ch.qos.logback', module='logback-core', version='1.1.7')
@Grab(group='com.hybris.caas', module='mydsl', version='0.0.1')
@GrabExclude('org.codehaus.groovy:groovy-xml')
import MyData
import data.TestData
import static mooncake.smoke.mt.config.Setting.lab


/*
 * yaml configuration
 * if not set my.yaml.dir, find yaml in .
 * if set my.yaml.dir, find yaml in value{my.yaml.dir}
 */
println (new File('.').getCanonicalPath())
lab()

d = new MyData()
println d.a
println d.b

d2 = new TestData()
println d.a
println d.b

println 'completed.'