# PluginDemo

<br>难点1：通过类加载器机制，加载插件dex，然后和宿主的dex合并为一个dexElements，然后设置回宿主的类加载器<br/>
<br>难点2：四大组件的加载，在进入AMS之前，通过hook机制，动态代理IActivityManager，判断如果当前方法是startActivity，将Activity替换为ProxyActivity，然后设置在handler中的callback，再把原来的intent设置回去，达到偷梁换柱的目的。<br/>
<br>难点3：资源加载，在插件中创建context，再创建创建插件Resources，将插件apk所在的路径设置到Resources中，然后通过反射，将Resources设置到context中，插件加载资源时就使用这个context，解决了资源冲突问题。<br/>
