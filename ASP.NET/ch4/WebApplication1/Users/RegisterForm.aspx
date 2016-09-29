<%@ Page Title="" Language="C#" MasterPageFile="~/Master.Master" AutoEventWireup="true" CodeBehind="RegisterForm.aspx.cs" Inherits="WebApplication1.Users.RegisterForm" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">

    <style type="text/css">
        .auto-style1 {
            width: 100px;
        }

        .auto-style2 {
            width: 200px;
        }

        .auto-style3 {
            width: 150px;
        }

        .auto-style4 {
            width: 100px;
            height: 26px;
        }

        .auto-style5 {
            width: 200px;
            height: 26px;
        }

        .auto-style6 {
            width: 150px;
            height: 26px;
        }
    </style>
    
    <script src="../bin/jquery-1.7.1.min.js" type="text/javascript"> </script>
    <script type="text/javascript">
        $(document).ready(function () {
            alert("111");
        });
        function ClientValidation(source, value) {
            alert("222");
            var str = value.Value;
            var len = 0;
            for (var i = 0; i < str.length; i++)
                if (str.charCodeAt(i) > 128)
                    len += 2;
                else
                    len++;

            if (len < 6)
                value.IsValid = false;

            else
                value.IsValid = true;

        }
    </script>

</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphContent" runat="server">

    <div>

        <h1>新用户注册</h1>

    </div>
    <table style="width: 100%; height: 219px;">
        <tr>
            <td class="auto-style1">
                <asp:Label ID="lblLoginId" runat="server" Text="用户名"></asp:Label>
            </td>
            <td class="auto-style2">
                <asp:TextBox ID="txtLoginId" runat="server"></asp:TextBox>



            </td>
            <td class="auto-style3">
                <asp:RequiredFieldValidator ID="rfvUserName" runat="server" ErrorMessage="请输入用户名" ControlToValidate="txtLoginId" Width="100px" Display="Dynamic">*</asp:RequiredFieldValidator></td>
        </tr>
        <tr>
            <td class="auto-style1">
                <asp:Label ID="Label1" runat="server" Text="密码"></asp:Label>
            </td>
            <td class="auto-style2">
                <asp:TextBox ID="txtLoginPwd" runat="server"></asp:TextBox>

            </td>
            <td class="auto-style3">
                <asp:RequiredFieldValidator ID="rfvPwd" runat="server" ErrorMessage="请输入密码" ControlToValidate="txtLoginPwd" Display="Dynamic">*</asp:RequiredFieldValidator></td>
        </tr>
        <tr>
            <td class="auto-style1">
                <asp:Label ID="Label2" runat="server" Text="重复密码"></asp:Label>
            </td>
            <td class="auto-style2">
                <asp:TextBox ID="txtReLoginPwd" runat="server"></asp:TextBox>
            </td>
            <td class="auto-style3">
                <asp:RequiredFieldValidator ID="rfvRePwd" runat="server" ErrorMessage="请输入重复密码" ControlToValidate="txtReLoginPwd" Display="Dynamic">*</asp:RequiredFieldValidator>

                <asp:CompareValidator ID="cvRePwd" runat="server" ErrorMessage="密码不一致" ControlToCompare="txtLoginPwd" ControlToValidate="txtReLoginPwd" Display="Dynamic">*</asp:CompareValidator>
            </td>
        </tr>
        <tr>
            <td class="auto-style1">姓名</td>
            <td class="auto-style5">
                <asp:TextBox ID="txtName" runat="server"></asp:TextBox>
            </td>
            <td class="auto-style6">
                <asp:RequiredFieldValidator ID="rfvName" runat="server" ErrorMessage="请输入姓名" ControlToValidate="txtName" Display="Dynamic">*</asp:RequiredFieldValidator>

                <asp:CustomValidator ID="csvName" runat="server" ControlToValidate="txtName" ErrorMessage="姓名格式不正确" ClientValidationFunction="ClientValidation" OnServerValidate="csvName_ServerValidate" ValidateEmptyText="True" Display="Dynamic">*</asp:CustomValidator>
            </td>
        </tr>
        <tr>
            <td class="auto-style1">地址</td>
            <td class="auto-style2">
                <asp:TextBox ID="txtAddress" runat="server"></asp:TextBox>
            </td>
            <td class="auto-style3">
                <asp:RequiredFieldValidator ID="rfvAddress" runat="server" ControlToValidate="txtAddress" ErrorMessage="请输入地址" Display="Dynamic">*</asp:RequiredFieldValidator>
            </td>
        </tr>
        <tr>
            <td class="auto-style1">电话</td>
            <td class="auto-style2">
                <asp:TextBox ID="txtPhone" runat="server"></asp:TextBox>
            </td>
            <td class="auto-style3">
                <asp:RequiredFieldValidator ID="rfvPhone" runat="server" ControlToValidate="txtPhone" ErrorMessage="请输入电话号码" Display="Dynamic">*</asp:RequiredFieldValidator>
            </td>
        </tr>
        <tr>
            <td class="auto-style1">邮箱</td>
            <td class="auto-style2">
                <asp:TextBox ID="txtMail" runat="server"></asp:TextBox>
            </td>
            <td class="auto-style3">
                <asp:RequiredFieldValidator ID="rfvMail" runat="server" ControlToValidate="txtMail" ErrorMessage="请输入邮箱" Display="Dynamic">*</asp:RequiredFieldValidator>

                <asp:RegularExpressionValidator ID="revMail" runat="server" ControlToValidate="txtMail" ErrorMessage="邮箱格式不正确" ValidationExpression="\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*" Display="Dynamic">*</asp:RegularExpressionValidator>
            </td>
        </tr>
        <tr>
            <td class="auto-style1">年龄</td>
            <td class="auto-style2">
                <asp:TextBox ID="txtAge" runat="server"></asp:TextBox>
            </td>
            <td class="auto-style3">
                <asp:RequiredFieldValidator ID="rfvAge" runat="server" ControlToValidate="txtAge" ErrorMessage="请输入年龄" Display="Dynamic">*</asp:RequiredFieldValidator>

                <asp:RangeValidator ID="rvAge" runat="server" ControlToValidate="txtAge" ErrorMessage="年龄应该在15岁以上" MinimumValue="15" Type="Integer" MaximumValue="100" Display="Dynamic">*</asp:RangeValidator>
            </td>
        </tr>
        <tr>
            <td class="auto-style4">预约日期</td>
            <td class="auto-style5">
                <asp:TextBox ID="txtDate" runat="server"></asp:TextBox>
            </td>
            <td class="auto-style6">
                <asp:RequiredFieldValidator ID="rfvDate" runat="server" ErrorMessage="请输入预约日期" ControlToValidate="txtDate" Display="Dynamic">*</asp:RequiredFieldValidator>

                <asp:RangeValidator ID="rvDate" runat="server" ControlToValidate="txtDate" ErrorMessage="只能选择10月" MaximumValue="2000-10-31" MinimumValue="2000-10-1" Type="Date" Display="Dynamic">*</asp:RangeValidator>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <asp:Button ID="btnOK" runat="server" Text="注册" OnClick="btnOK_Click" />
                <asp:Button ID="btnReset" runat="server" Text="重置" OnClick="btnReset_Click" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <asp:ValidationSummary
                    ID="valSum"
                    DisplayMode="BulletList"
                    ShowMessageBox="true"
                    HeaderText="You must enter a value in the following fields:"
                    Font-Names="verdana"
                    Font-Size="12"
                    runat="server" />
                <asp:Label ID="lblMessage" runat="server"></asp:Label>
            </td>
        </tr>
    </table>


</asp:Content>
