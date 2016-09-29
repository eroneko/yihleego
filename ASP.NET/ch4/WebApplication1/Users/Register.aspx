<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Register.aspx.cs" Inherits="WebApplication1.Users.Register" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <style type="text/css">
        .auto-style1 {
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        新用户注册<br />
    
    </div>
        <table style="width: 42%; height: 219px;">
            <tr>
                <td class="auto-style1">
        <asp:Label ID="lblLoginId" runat="server" Text="用户名"></asp:Label>
                </td>
                <td>
        <asp:TextBox ID="txtLoginId" runat="server"></asp:TextBox>
    
                </td>
            </tr>
            <tr>
                <td class="auto-style1">
        <asp:Label ID="Label1" runat="server" Text="密码"></asp:Label>
                </td>
                <td>
        <asp:TextBox ID="txtLoginPwd" runat="server"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style1">
        <asp:Label ID="Label2" runat="server" Text="重复密码"></asp:Label>
                </td>
                <td>
        <asp:TextBox ID="txtReLoginPwd" runat="server"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style1">
                    姓名</td>
                <td>
        <asp:TextBox ID="txtName" runat="server"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style1">
                    地址</td>
                <td>
        <asp:TextBox ID="txtAddress" runat="server"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style1">
                    电话</td>
                <td>
        <asp:TextBox ID="txtPhone" runat="server"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style1">
                    邮箱</td>
                <td>
        <asp:TextBox ID="txtMail" runat="server"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style1" colspan="2">
            <asp:Button ID="btnOK" runat="server" Text="注册" OnClick="btnOK_Click" />
            <asp:Button ID="btnReset" runat="server" Text="重置" />
                </td>
            </tr>
            </table>
        <asp:Label ID="lblMessage" runat="server"></asp:Label>
    </form>
</body>
</html>
