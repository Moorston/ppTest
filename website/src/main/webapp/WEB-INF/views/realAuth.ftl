<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>神庙-实名认证</title>
<#include "common/link.ftl" />
    <link type="text/css" rel="stylesheet" href="/css/account.css"/>
    <script type="text/javascript" src="/plugin/uploadify/jquery.uploadify.min.js"></script>
    <script type="text/javascript" src="/plugin/js/jquery.form.js"></script>
    <script type="text/javascript" src="/plugin/jquery-validation/jquery.validate.js"></script>
    <style type="text/css">
        #realAuthForm input,#realAuthForm select{
            width: 260px;
        }
        .idCardItem{
            width: 160px;
            height: 150px;
            float: left;
            margin-right: 10px;
            border: 1px solid #e3e3e3;
            text-align: center;
            padding: 5px;
        }
        .uploadImg{
            width: 120px;
            height: 100px;
            margin-top: 5px;
        }
        #viewExample{
            position: relative;
            left: 50px;
            top: 60px;
        }
        .uploadExample{
            width: 200px;
            height: 130px;
            margin-bottom: 20px;
        }
        .swfupload{
            left: 0px;
            cursor: pointer;
        }
        .uploadify{
            height: 20px;
            font-size:13px;
            line-height:20px;
            text-align:center;
            position: relative;
            margin-left:auto;
            margin-right:auto;
            cursor:pointer;
            background-color: #337ab7;
            border-color: #2e6da4;
            color: #fff;
        }

    </style>

    <script type="text/javascript">
        $(function () {

            $("#viewExample").popover({
                html: true,// 为true的话，data-content里就能放html代码了
                //content这里可以直接写字符串，也可以 是一个函数，该函数返回一个字符串；
                content: '正面<img src="/images/upload_source_2.jpg" class="uploadExample"/><br/>' +
                '反面<img src="/images/upload_source_2_1.jpg" class="uploadExample">',
                trigger: "hover",//触发方式
                placement: "top"//弹出的位置How to position the popover - top | bottom | left | right | auto.
            });

            //把上传身份证正面的a标签变成一个uploadify的组件
            $("#uploadBtn1").uploadify({
                buttonText: "身份证正面",
                fileObjName: "file",
                fileTypeDesc: "身份证正面图片",
                fileTypeExts: "*.gif;*.jpg;*.png",
                multi: false,
                swf: "/plugin/uploadify/uploadify.swf",
                uploader: "/realAuthUpload.do",
                overrideEvents: ["onUploadSuccess", "onSelect"],
                onUploadSuccess: function (file, data) {
                    $("#uploadImg1").attr("src", data);
                    $("#uploadImage1").val(data);
                },
                onUploadError: function (file, errorCode, errorMsg, errorString) {
                    alert('The file ' + file.name + ' could not be uploaded: ' + errorString);
                }
            });

            $("#uploadBtn2").uploadify({
                buttonText: "身份证反面",
                fileObjName: "file",
                fileTypeDesc: "身份证正面图片",
                fileTypeExts: "*.gif;*.jpg;*.png",
                multi: false,
                swf: "/plugin/uploadify/uploadify.swf",
                uploader: "/realAuthUpload.do",
                overrideEvents: ["onUploadSuccess", "onSelect"],
                onUploadSuccess: function (file, data) {
                    $("#uploadImg2").attr("src", data);
                    $("#uploadImage2").val(data);
                },
                onUploadError: function (file, errorCode, errorMsg, errorString) {
                    alert('The file ' + file.name + ' could not be uploaded: ' + errorString);
                }
            });

        $("#realAuthForm").validate({
            rules: {
                realName: "required",
                idNumber: {
                    required: true,
                    rangelength:[8,18]
                },
                address:"required"
            },
            messages: {
                realName: "请输入姓名",
                idNumber: {
                    required: "请输入您的身份证号码",
                    rangelength:"身份证号码的位数不匹配"
                },
                address:"请输入您的身份证件所在地",
                bornDate:"请输入您的出生日期"
            },
            submitHandler: function() {
                alert("ww");
            },
            errorClass:"text-danger",
            highlight: function(element, errorClass, validClass) {
                $(element).addClass(errorClass).removeClass(validClass);

            },
            unhighlight: function(element, errorClass, validClass) {
                $(element).removeClass(errorClass).addClass(validClass);

            }

        });

            $("#submitBtn").bind("click", function () {

                $.messager.confirm("温馨提示：", "提交后不能修改，确定提交吗？", function () {
                    //ajax提交表单
                    $("#realAuthForm").ajaxSubmit({
                        success: function (data) {
                            if (data.success) {
                                $.messager.confirm("提示：", "提交成功！请点击确定进入查看认证信息页面",
                                        function () {
                                            window.location.reload();
                                        });
                            } else {
                                $.messager.popup(data.msg);
                                window.location.reload();
                            }
                        },
                        error: function () {
                            $.messager.popup(data.msg);
                            window.location.reload();
                        }
                    });
                });
            });

        });


    </script>

</head>
<body>
<!-- 网页顶部导航 -->
<#include "common/headNav.ftl"/>
<#assign currentNav="personal" />
<#include "common/nav.ftl" />

<div class="container">
    <div class="row">
        <!--导航菜单-->
        <div class="col-sm-3">
        <#assign currentMenu="realAuth"/>
				<#include "common/leftMenu.ftl" />
        </div>
        <!-- 功能页面 -->
        <div class="col-sm-9">
            <div class="panel panel-default">
                <div class="panel-heading">
                    实名认证
                </div>
                <form class="form-horizontal" id="realAuthForm" method="post" action="/applyRealAuth.do"
                      novalidate="novalidate" enctype="multipart/form-data">
                    <fieldset>
                        <div class="form-group">
                            <p class="text-center text-danger">为保护您账户安全，实名认证成功之后不能修改信息，请认真填写！</p>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label ">用户名</label>
                            <div class="col-sm-8">
                                <p class="form-control-static">${logininfo.username}</p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label" for="realName">姓名</label>
                            <div class="col-sm-8">
                                <input id="realName" name="realName" class="form-control" type="text" value="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4  control-label" for="sex">性别</label>
                            <div class="col-sm-8">
                                <select id="sex" class="form-control" name="sex" size="1">
                                    <option value="0">男</option>
                                    <option value="1">女</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4  control-label" for="idnumber">证件号码</label>
                            <div class="col-sm-8">
                                <input id="idNumber" class="form-control" name="idNumber" type="text" value="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4  control-label" for="bornDate">出生日期</label>
                            <div class="col-sm-8">
                                <input id="birthDate" class="form-control" name="bornDate" type="text">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4  control-label" for="address">证件地址</label>
                            <div class="col-sm-8">
                                <input id="address" class="form-control" name="address" type="text"
                                       style="max-width: 100%;width:500px;">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-4  control-label" for="address">身份证照片</label>
                            <div class="col-sm-8">
                                <p class="text-help text-primary">请点击“选择图片”,选择证件的正反两面照片。</p>
                                <a href="javascript:;" id="viewExample">查看样板</a>
                                <div class="idCardItem">
                                    <div>
                                        <a href="javascript:;" id="uploadBtn1">上传正面</a>
                                    </div>
                                    <img alt="" src="" class="uploadImg" id="uploadImg1"/>
                                    <input type="hidden" name="image1" id="uploadImage1"/>
                                </div>
                                <div class="idCardItem">
                                    <div>
                                        <a href="javascript:;" id="uploadBtn2">上传反面</a>
                                    </div>
                                    <img alt="" src="" class="uploadImg" id="uploadImg2"/>
                                    <input type="hidden" name="image2" id="uploadImage2"/>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <button type="button" id="submitBtn" class="btn btn-primary col-sm-offset-4"
                                     data-loading-text="正在提交" ><i class="icon-ok"></i> 提交认证
                            </button>
                        </div>
                    </fieldset>
                </form>
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