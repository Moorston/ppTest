<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>神庙（${logininfo.username}）-登录日志</title>
    <#include "common/link.ftl" />
    <link type="text/css" rel="stylesheet" href="/css/account.css"/>
    <script type="text/javascript" src="/plugin/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="/plugin/js/plugins-override.js"></script>
    <script type="text/javascript" src="/plugin/js/jquery.twbsPagination.min.js"></script>
    <script type="text/javascript">
        $(function() {
            //日历控件
            $(".beginDate,.endDate").click(function () {
                WdatePicker();
            });

            //注册查询按钮,按钮要传递endDate、beginDate、loginstate登录状态、loginType（用户类型）
            $("#query").click(function () {
                $("#currentPage").val(1);
                $("#searchForm").submit();
            });

            //分页
            $("#pagination").twbsPagination({
                totalPages: ${pageResult.totalPage},//总页数
                startPage: ${pageResult.currentPage},
                visiblePages: 5,//显示的页数
                first: '首页',
                prev: '前一页',
                next: '下一页',
                last: '尾页',
                //点击请求数据
                onPageClick: function (event, page) {
                    console.log(page);//page为当前页码
                    $("#currentPage").val(page);
                    $("#searchForm").submit();
                }

            });
        });
    </script>
</head>
<body>

<!-- 网页顶部导航 -->
<#include "common/headNav.ftl" />
<!-- 网页导航 -->
<#assign currentNav="personal" />
<#include "common/nav.ftl" />

<div class="container">
    <div class="row">
        <!--导航菜单-->
        <div class="col-sm-3">
        <#assign currentMenu="ipLog" />
					<#include "common/leftMenu.ftl" />
        </div>
        <!-- 功能页面 -->
        <div class="col-sm-9" style="margin-top: 30px">
            <form action="/ipLog.do" name="searchForm" id="searchForm" class="form-inline" method="post">
                <input type="hidden" id="currentPage" name="currentPage" value=""/>
                <div class="form-group">
                    <label>时间范围</label>
                    <input type="text" class="form-control beginDate" name="beginDate"
                           value='${(qo.beginDate?string("yyyy-MM-dd HH:mm:ss"))!""}'/>
                </div>
                <div class="form-group">
                    <label></label>
                    <input type="text" class="form-control endDate" name="endDate"
                        value="${(qo.endDate?string("yyyy-MM-dd HH:mm:ss"))!""}"/>
                </div>
                <div class="form-group">
                    <label>状态</label>
                    <select class="form-control" name="loginstate" id="loginState">
                        <option value="-1">全部</option>
                        <option value="0">登录失败</option>
                        <option value="1">登录成功</option>
                    </select>
                    <script type="text/javascript">
                        $("#loginState option=[${qo.loginstate}]").attr("selected",true);
                    </script>
                </div>
                <div class="form-group">
                    <button type="button" id="query" class="btn btn-success"><i class="icon-search"></i> 查询</button>
                </div>
            </form>

            <div class="panel panel-default" style="margin-top: 20px;">
                <div class="panel-heading">
                    登录日志
                </div>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>用户</th>
                        <th>登录时间</th>
                        <th>登录ip</th>
                        <th>登录状态</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list pageResult.listData as item>
                    <tr>
                        <td>${item.username}</td>
                        <td>${item.loginTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                        <td>${item.ip}</td>
                        <td>${(item.loginstate==1)?string('Success','Fail')}</td>
                    </tr>
                    </#list>
                    </tbody>
                </table>
                <div style="text-align: center;">
                    <ul id="pagination" class="pagination"></ul>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="copy-rights" >
    <div class="bg bg-blur"></div>
    <p>Copyright &copy; 2017 Where you yourself are right,nothing that happens to you ever has wrong
        <a href="http://www.momo.com/" target="_blank" title="意趣">意趣</a> - Collect from <a href="http://www.momo.com/" title="意趣" target="_blank">意趣</a></p>
</div>
</body>
</html>