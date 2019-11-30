# 项目名称 bookManager
@Created by lizeyang on 2019/11/25
<br>
@fdescription bookManager
****
## 2019/11/25 第一次提交
### 1.后台功能实现
* （1）对数据库的表操作，创建、插入、修改和删除
建立bookmanager数据库，新建books表格，字段和数据信息见下图：<br>
>>> 说明：需要依赖（WEB-INF/lib）：c3p0.jar，commons-dbutils-1.4.jar，mysql-connector-java-5.0.8-bin.jar<br>
![image](https://github.com/lizeyang18/bookManager/blob/master/web/img_folder/mysql.PNG)<br>

* （2）将数据库表中的书本信息显示在前端jsp中(admin/products/list.jsp)，支持对书本的添加(admin/products/add.jsp)、单个修改(admin/products/edit.jsp)和删除、批量删除<br>
>>> 说明：需要依赖：jstl.jar,standard.jar
* （3）`多条件` 查询书本<br/>
![image](https://github.com/lizeyang18/bookManager/blob/master/web/img_folder/list.PNG)<br/>

### 2.前端功能实现
* （1）将书本信息分页显示<br/>
![image](https://github.com/lizeyang18/bookManager/blob/master/web/img_folder/dividePage.PNG)

****
## 2019/11/30 第二次提交
### 1.后台功能实现
* （1）实现书本加入购物车功能<br>
>>> 说明：具体判断如果相同书本添加购物车则数量自增——通过每本书ID的hashcode值进行equal判断<br>
![image](https://github.com/lizeyang18/bookManager/blob/master/web/img_folder/order.PNG)<br>

* （2）在购物车中改变商品数量按钮，通过ajax实时显示修改结果<br>
>>> 说明：每个商品的数量+, -按钮联动改变的有：小计、合计，其中最大数量不能超过库存数量<br>
![image](https://github.com/lizeyang18/bookManager/blob/master/web/img_folder/cart.PNG)<br>

* （3）上传商品图片<br>
>>> 说明： 按照日期存储各个图片，未限制图片大小，但在后台修改书本信息时，若修改了书本图片（前提在添加书本时必须添加图片），则在数据库中改变图片地址的同时删除原先照片<br>
![image](https://github.com/lizeyang18/bookManager/blob/master/web/img_folder/upload.PNG)<br>

### 2.前端功能实现
* （1）主页搜索框模糊查询<br>
>>> 说明：通过js实现，触发模糊查询(/WEB-INF/menu_search.jsp)<br>
![image](https://github.com/lizeyang18/bookManager/blob/master/web/img_folder/search.jpg)<br>

****
