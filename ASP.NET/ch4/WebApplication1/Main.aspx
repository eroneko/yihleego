<%@ Page Title="" Language="C#" MasterPageFile="~/Master.Master" AutoEventWireup="true" CodeBehind="Main.aspx.cs" Inherits="WebApplication1.Main" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <script language="javascript">
        function getAllSelect(all) {
            //alert(all.checked);
            var items = document.getElementsByTagName("input");
            for (i = 0; i < items.length; i++) {
                if (items[i].type == "checkbox") {
                    items[i].checked = all.checked;
                }
            }
        }
    </script>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphContent" runat="server">



    <h1>
        <asp:Label ID="lblMessage" runat="server" Text="Label"></asp:Label></h1>




    <asp:GridView ID="gvBook" runat="server" AutoGenerateColumns="False" DataSourceID="odsBook" AllowPaging="True" CellPadding="4" ForeColor="#333333" GridLines="None" PageSize="15" Width="100%" Height="100%" OnRowDataBound="gvBook_RowDataBound">
        <AlternatingRowStyle BackColor="White" />
        <Columns>
            <asp:TemplateField HeaderText="全选">
                <HeaderTemplate>
                    <input id="Checkbox1" type="checkbox" onclick="getAllSelect(this);" />全选                        
                </HeaderTemplate>
                <ItemTemplate>
                    &nbsp;<asp:CheckBox ID="ckbSelected" runat="server" />
                </ItemTemplate>
            </asp:TemplateField>
            <asp:TemplateField HeaderText="Id" SortExpression="Id" Visible="False">
                <EditItemTemplate>
                    <asp:Label ID="Label1" runat="server" Text='<%# Eval("Id") %>'></asp:Label>
                </EditItemTemplate>
                <ItemTemplate>
                    <asp:Label ID="lblID" runat="server" Text='<%# Bind("Id") %>'></asp:Label>
                </ItemTemplate>
            </asp:TemplateField>
            <asp:BoundField DataField="Title" HeaderText="书名" SortExpression="Title" />
            <asp:BoundField DataField="UnitPrice" HeaderText="单价" SortExpression="UnitPrice" DataFormatString="{0:c}" />
            <asp:TemplateField HeaderText="类别" SortExpression="Category">
                <EditItemTemplate>
                    <asp:TextBox ID="TextBox1" runat="server" Text='<%# Bind("Category") %>'></asp:TextBox>
                </EditItemTemplate>
                <ItemTemplate>
                    <asp:Label ID="Label1" runat="server" Text='<%# Eval("Category.Name") %>'></asp:Label>
                </ItemTemplate>
            </asp:TemplateField>
            <asp:BoundField DataField="PublishDate" DataFormatString="{0:yyyy-MM-dd}" HeaderText="出版日期" SortExpression="PublishDate" />
            <asp:HyperLinkField DataNavigateUrlFields="Id" DataNavigateUrlFormatString="bookDetail.aspx?id={0}" HeaderText="查看" Text="详情" />
        </Columns>
        <EditRowStyle BackColor="#2461BF" />
        <FooterStyle BackColor="#507CD1" Font-Bold="True" ForeColor="White" />
        <HeaderStyle BackColor="#507CD1" Font-Bold="True" ForeColor="White" />
        <PagerStyle BackColor="#2461BF" ForeColor="White" HorizontalAlign="Center" />
        <RowStyle BackColor="#EFF3FB" />
        <SelectedRowStyle BackColor="#D1DDF1" Font-Bold="True" ForeColor="#333333" />
        <SortedAscendingCellStyle BackColor="#F5F7FB" />
        <SortedAscendingHeaderStyle BackColor="#6D95E1" />
        <SortedDescendingCellStyle BackColor="#E9EBEF" />
        <SortedDescendingHeaderStyle BackColor="#4870BE" />
    </asp:GridView>
    <p>修改选定图书类别:<asp:DropDownList ID="ddlUpdateCategory" runat="server" DataSourceID="odsUpdateCategory" DataTextField="Name" DataValueField="Id" Width="150px">
        </asp:DropDownList>
        <asp:ObjectDataSource ID="odsUpdateCategory" runat="server" SelectMethod="GetAllCategories" TypeName="MyBookShopBLL.BookManager"></asp:ObjectDataSource>
        <asp:Button ID="btnUpdate" runat="server" Text="确认修改" OnClick="btnUpdate_Click" />
    </p>

    <asp:ObjectDataSource ID="odsBook" runat="server" SelectMethod="GetAllBooks" TypeName="MyBookShopBLL.BookManager"></asp:ObjectDataSource>


</asp:Content>
