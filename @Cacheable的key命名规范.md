#key属性是用来指定Spring缓存方法的返回结果时对应的key的。该属性支持SpringEL表达式。当我们没有指定该属性时，
Spring将使用默认策略生成key。我们这里先来看看自定义策略，至于默认策略会在后文单独介绍。

#自定义策略是指我们可以通过Spring的EL表达式来指定我们的key。这里的EL表达式可以使用方法参数及它们对应的属性。
使用方法参数时我们可以直接使用“#参数名”或者“#p参数index”。下面是几个使用参数作为key的示例。

@Cacheable(value="users", key="#id")
public User find(Integer id) {
  returnnull;
}

@Cacheable(value="users", key="#p0")
public User find(Integer id) {
  returnnull;
}

@Cacheable(value="users", key="#user.id")
public User find(User user) {
  returnnull;
}

@Cacheable(value="users", key="#p0.id")
public User find(User user) {
  returnnull;
}

除了上述使用方法参数作为key之外，Spring还为我们提供了一个root对象可以用来生成key。通过该root对象我们可以获取到以下信息。
----------------------------------------------------------------------------
属性名称        |    描述                           |     示例
methodName     |   当前方法名                       |     #root.methodName
method         |   当前方法                         |     #root.method.name
target         |   当前被调用的对象                  |     #root.target
targetClass    |   当前被调用的对象的class           |     #root.targetClass
args           |   当前方法参数组成的数组             |     #root.args[0]
caches         |   当前被调用的方法使用的Cache        |     #root.caches[0].name

当我们要使用root对象的属性作为key时我们也可以将“#root”省略，因为Spring默认使用的就是root对象的属性。如：
@Cacheable(value={"users","xxx"}, key="caches[1].name")
public User find(User user) {

  returnnull;

}

如果要调用当前类里面的方法
@Override
@Cacheable(value = {"TeacherAnalysis_public_chart"}, key = "#root.target.getDictTableName() + '_' + #root.target.getFieldName()")
public List<Map<String, Object>> getChartList(Map<String, Object> paramMap) {
}

public String getDictTableName() {
    return "";
}

public String getFieldName() {
    return "";
}

