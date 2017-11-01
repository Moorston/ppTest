<div class="navbar navbar-default sm-navbar">
    <div class="container">
        <div class="navbar-header">
            <a href="/">
                <img src="/images/logo.jpg" width="135px" height="52px" style="padding: 0px 20px 0px 0px">
            </a>
        </div>

        <ul class="nav navbar-nav">
            <li id="index"><a href="/index.do">首页</a></li>
            <li id="invest"><a href="/invest.do">我要投资</a></li>
            <li id="borrow"><a href="/borrow.do">我要借款</a></li>
            <li id="personal"><a href="/personal.do">个人中心</a></li>
            <li><a href="#">新手指引</a></li>
            <li><a href="#">关于我们</a></li>
        </ul>

    </div>
</div>

<#if currentNav??>
<script type="text/javascript">
    $("#"+"${currentNav}").addClass("active");
</script>
</#if>

