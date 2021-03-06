<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page import="com.imooc.oa.global.Content" %>

<jsp:include page="top.jsp"/>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 待处理报销单 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel  heading-border">
                <div class="panel-menu">
                    <div class="row">
                        <div class="hidden-xs hidden-sm col-md-3">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-refresh"></i>
                                </button>
                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-trash"></i>
                                </button>
                            </div>
                        </div>
                        <div class="col-xs-12 col-md-9 text-right">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-chevron-left"></i>
                                </button>
                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-chevron-right"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel-body pn">
                    <table id="message-table" class="table admin-form theme-warning tc-checkbox-1">
                        <thead>
                        <tr class="">
                            <th class="text-center hidden-xs">Select</th>
                            <th class="hidden-xs">事由</th>
                            <th>状态</th>
                            <th class="hidden-xs">创建人</th>
                            <th class="hidden-xs">金额</th>
                            <th class="text-center">创建时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        
                            <tr class="message-unread">
                                <td class="hidden-xs">
                                    <label class="option block mn">
                                        <input type="checkbox" name="mobileos" value="FR">
                                        <span class="checkbox mn"></span>
                                    </label>
                                </td>
                                <c:forEach items="${deal}" var="d">
                                <td>${d.cause}</td>
                                <td class="hidden-xs">
                                    <span class="badge badge-warning mr10 fs11"> ${d.status} </span>
                                </td>
                                <td>${d.createSn}</td>
                                <td class="text-center fw600">${d.totalAmount}</td>
                                <td><spring:eval expression="d.createTime"/></td>
                                <td>
                                    <c:if test="${d.status == Content.CLAIM_VOUCHER_CREATE || d.status == Content.CLAIM_VOUCHER_BACK}">
                                        <a href="/claim_voucher/to_update?id=${d.id}">修改</a>
                                        <a href="/claim_voucher/submit?id=${d.id}">提交</a>
                                    </c:if>
                                    <c:if test="${d.status == Content.CLAIM_VOUCHER_RECHECK || d.status == Content.CLAIM_VOUCHER_SUBMIT}">
                                        <a href="/claim_voucher/to_update?id=${d.id}">通过</a>
                                        <a href="/claim_voucher/submit?id=${d.id}">打回</a>
                                    </c:if>
                                    <c:if test="${d.status == Content.CLAIM_VOUCHER_APPROVED}">
                                        <a href="/claim_voucher/detail?id=${d.id}">打款</a>
                                    </c:if>
                                    <a href="/claim_voucher/detail?id=${d.id}">详细信息</a>
                                </td>
                                </c:forEach>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>

