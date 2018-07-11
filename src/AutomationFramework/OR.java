package AutomationFramework;

import org.openqa.selenium.By;

public class OR {

	// Login Page
	public static String Login_link="LinkLogin#lnktext=Login with Hybrent";
	public static String HeaderLogo = "Logo#xpath=//img";
	public static String Label_username = "Labelusername#xpath=//*[@for='userName']";
	public static String Label_password = "Labelpassword#xpath=//*[@for='password']";
	public static String Login_Username = "Input_UserName#id=userName";
	public static String Login_Password = "Input_Password#id=password";
	public static String Login_Submit = "LoginBtn#xpath=//*[@type='submit']";
	public static String Login_Error = "Error#xpath=//h2[contains(text(),'Error?')]";
	public static String Login_Validation = "ErrorValidation#xpath=//*[contains(text(),'Invalid user name or password.')]";
	public static String Login_okay = "Errorok#xpath=//*[@class='confirm']";
	
	public static String DashBoard = "DashBoard#xpath=//a[@href='#/dashboard']";

	public static String Dashboard_Order_Table= "Dashboard_Order_Table#xpath=//*[@id='reqListing']";

	// Shop
	public static String Shop_Menu= "ShopMenu#xpath=//*[@href='#/shop']";
	public static String Shop_wait= "Shopwait#xpath=//*[@id='ng-view']";
	public static String Shop_UpdatePrice= "UpdatePrice#xpath=//*[@ng-click=\"contractPriceCtrl.continue('update')\"]";
	public static String Shop_UpdatePrice1= "UpdatePrice#xpath=(//*[@class='modal-footer']//button[text()='Update Price'])[1]";
	public static String Shop_SearchItemin= "SearchItemin#xpath=//*[contains(text(),'Search item in')]";
	public static String Shop_Shopfor = "ShopFor#xpath=//*[contains(text(),'Shopping for')]";
	public static String Shop_Shopfor_selectedFacility = "selectedFacility#xpath=//*[@uib-tooltip='Click to change facility.']";
	public static String Shop_SHopfor_ShopfaclitySelect = "SelectShopfaclity#xpath=//*[@title='Select Facility']";
	public static String Shop_Shopfor_Button_selected_Disable = "BtndisaableSelecetd#xpath=//*[@uib-tooltip='Click to change facility.']";
	public static String Shop_SHopfor_getfacilityName = "getfacilityName#xpath=//*[@ng-click='selectItem();']";
	public static String Shop_SHopfor_allfacilityArray = "allfacilityArray#xpath=//td";
	public static String Shop_SHopfor_selectedFAcility = "selectedFAcility#xpath=//*[@disabled='disabled']";
	public static String Shop_SHopfor_cancelButtonPopup = "cancelButtonPopup#xpath=//*[@ng-click='cancel()']";
	public static String Shop_SHopfor_Shopfaclity = "Shopfaclity#xpath=//*[text()='Select Facility']";
	public static String Shop_SHopfor_FacInDropDown="selectedFacInDropDown#xpath=//*[@title='Select Facility']//a";
	public static String Shop_SHopfor_SearchMenu_SKU = "SearchMenu_SKU#xpath=//*[contains(@ng-click, 'setSelectedItem(getPropertyForObject(option,settings.idProp))') and contains(text(),'SKU')]";
	public static String Shop_SHopfor_SearchBox= "SearchBox#xpath=//*[@id='search']";
	public static String Shop_SHopfor_Search_itemdesc= "Search_itemdesc#xpath=//item-info";
	//    public static String Shop_SHopfor_Search_vendorName= "Search_vendorName#xpath=//vendor-info/span";
	public static String Shop_SHopfor_Search_Match= "Search_Match#xpath=//*[@id='matchselect']";
	public static String Shop_SHopfor_Search_skuName="skuName#xpath=//*[@class='table table-striped shopTable']//tr[1]//span";
	public static String Shop_SHopfor_SelectfirstItemvendorName= "vendorName#xpath=(//vendor-info)[1]/span";
	public static String Shop_SHopfor_clickvendorsinDropdown= "clickvendorsinDropdown#xpath=//*[@id='vendor']";
	public static String Shop_SHopfor_allvendorsinDropdown= "allvendorsinDropdown#xpath=//*[@id='vendor']/option";
	public static String Shop_SHopfor_MyInventoryradiobutton="MyInventoryradiobutton#xpath=//*[@id='searchShop']/div[1]";
	public static String Shop_Qty_Close="Qty_Close#xpath=//*[@title='Cancel']";
	public static String Shop_Qty_Validation="Validation#xpath=//*[text()='Cart quantity can not be less than zero.']";
	public static String Shop_Qty_ValidationOK="ValidationOK#xpath=//*[text()='OK']";
	public static String Shop_SHopfor_RecentlyOrderedradiobutton="RecentlyOrderedradiobutton#xpath=//*[@id='searchShop']/div[2]";
	public static String Shop_SHopfor_MostOrderedradiobutton="MostOrderedradiobutton#xpath=//*[@id='searchShop']/div[3]";
	public static String Shop_SHopfor_FavOrderedradiobutton="FavOrderedradiobutton#xpath=//*[@id='searchShop']/div[4]";
	public static String Shop_selectExactMatch= "selectExactMatch#xpath=//*[@id='matchselect']";
	public static String Shop_SHopfor_ResultGridTab="ResultGridTab#xpath=//*[@id='ng-view']/div/div[2]/div[3]/grid-layout/div[2]/div/div/div/div/table/thead/tr/th[7]/a";
	public static String Shop_Item_First="Item_First#xpath=(//*[@value='name'])[1]";
	public static String Shop_SHopfor_LastorderedText="LastorderedText#xpath=//th[@class='ng-scope text-left']/a";
	public static String Shop_SHopfor_PoCountText="PoCountText#xpath=//th[@class='ng-scope text-right'][1]/a";
	public static String Shop_SHopfor_Addtocartt="Shop_SHopfor_Addtocartt#xpath=(//button[@ng-click='$ctrl.addItemToCart(item)'])[1]";
	public static String Shop_SHopfor_updatePrice="Shop_SHopfor_updatePrice#xpath=//*[@class='modal-header']//i";
	public static String Shop_SHopfor_favtab="favtab#xpath=(//*[@ ng-if=\"isShowFavorite == 'true'\"]/i)[1]";
	public static String Shop_SHopfor_myInventoryFavTab="myInventoryFavTab#xpath=//i[@ng-if='!isFavorite']";  
	public static String Shop_orgPage="orgPage#xpath=//*[@href='#/admin/organization']";
	public static String Shop_FeaturesPage="FeaturesPage#xpath=//ul[@class='nav nav-tabs']/li[2]/a";
	public static String Shop_Contractpriecradiobtn="Contractpriecradiobtn#xpath=//*[@id='use_list_price_no']";
	public static String Shop_listpriecradiobtn="Contractpriecradiobtn#xpath=//*[@id='use_list_price']";
	// validation
	public static String Shop_Alertvalidation="Validation#xpath=//*[text()='This item is not under contract or a preference item from your distributor, It may cost more.']";
	public static String Shop_Alert_Dontnotadd="DoNotAdd#xpath=//button[text()='Do not add to cart']";
	public static String Shop_Alert_Dontnotadd_checkbox="AlertStop#xpath=//*[@ng-click='Ctrl.stopAlert()']";
	public static String Shop_Checkoutbtn="Checkoutbtn#xpath=//button[contains(text(),'Checkout')]";
	
	// Most Ordered
	public static String Shop_Mostordered_Itemdescription="Itemdescription#xpath=//*[contains(text(),'Item Description')]";


	public static String Shop_SHopfor_drilldownicon="drilldownicon#xpath=(//button[@ng-readonly='moveingToPunchOutSite'])[1]";
	public static String Shop_SHopfor_showTourText="showTourText#xpath=//ul[@ng-readonly='moveingToPunchOutSite']/li[1]/a";

	public static String Shop_SHopfor_createNewLAyout="createNewLAyout#xpath=//li[@ng-click='newShopTableGrid(false);]";
	public static String Shop_SHopfor_Layoutpopup="Layoutpoup#xpath=//div[@class='headtext']";
	public static String Shop_SHopfor_Layoutpoupclose="Layoutpoupclose#xpath=//*[@class='close pull-right']";

	public static String Shop_SHopfor_copyLayoutpoup="copyLayoutpoup#xpath=//a[contains(text(),'Copy Current Layout')]";

	public static String Shop_SHopfor_showtourtextONPOPUP="showtourtext#xpath=//h3[contains(text(),'Shop: Search For')]";
	public static String Shop_SHopfor_showtourNextButtonText="showtourNextButtonText#xpath=//button[contains(text(),'Next ï¿½')]";
	//public static String Shop_SHopfor_showtourENDbuttonTExt="showtourENDbuttonTExt#xpath=//button[contains(text(),'End tour')]";
	public static String Shop_SHopfor_showtourENDbuttonTExt="showtourENDbuttonTExt#xpath=(//button[@ng-click='tour.end();'])[1]";

	public static String Shop_SHopfor_allFieldsBtn="allFieldsBtn#xpath=//div[@options='searchKeysList']/div/button";

	public static String Shop_SHopfor_Search_vendorName_Price= "Search_vendorName_price#xpath=//*[@current-price='item.purchase_price']/div";
	public static String Shop_SHopfor_Search_Addtocart= "Search_AddtocartBtn#xpath=(//*[@ng-click='$ctrl.addItemToCart(item)'])[1]";


	public static String Shop_GrandTotal = "GrandTotal#xpath=//*[@tour-step='cart-grand-total']/td";
	public static String Shop_GeneratePo = "GeneratePo#xpath=(//*[@id='btnAdd'])[1]";

	public static String Shop_Allfieldsbutton = "Shop_Allfieldsbutton#xpath=//*[@ng-click='toggleDropdown()']";
	public static String Shop_waitdropdown = "Shop_waitdropdown#xpath=//*[@role='menuitem']";
	public static String Shop_orgpage = "Shop_Shop_orgpage#xpath=//*[@ng-href='#/admin/organization']";
	public static String Shop_orgFeaturesPage = "Shop_orgFeaturesPage#xpath=//ul[@class='nav nav-tabs']";
	public static String Shop_orgFeatures2Page = "Shop_orgFeaturesPage#xpath=//a[text()='Features']";
	public static String Shop_crosswalktogglevalue ="Shop_crosswalktogglevalue#xpath=//*[@class='col-sm-8 user-action-switch']/div";
	public static String Shop_crosswalktoggleON ="Shop_crosswalktoggleON#xpath=";
	public static String Shop_dropDownText ="Shop_dropDownText#xpath=//*[@ng-show='settings.selectionLimit > 1']/a ";
	public static String Shop_searchfield= "searchfield#xpath=//*[@id='search']";
	public static String Shop_ifnoItemfield= "ifnoItemfield#xpath=//tr[@ng-if='!items.length']/td";
	//public static String Shop_wait= "ifnoItemfield#xpath=//tr[@ng-if='!items.length']/td";

	public static String Shop_showTour= "showTour#xpath=//li[@ng-click='startTour();']";
	public static String Shop_showTour1= "showTour#xpath=//a[text()='Show Tour']";
	public static String Shop_showTour_Message= "Message#xpath=//*[contains(@class, 'tourStep') and contains(@class, 'tether-enabled')]//*[@class='popover-content tour-step-content']";
	public static String Shop_showTour_Next= "Next#xpath=//*[contains(@class, 'tourStep') and contains(@class, 'tether-enabled')]//button[text()='Next »']";
	public static String Shop_showTour_EndTour= "EndTour#xpath=//*[contains(@class, 'tourStep') and contains(@class, 'tether-enabled')]//button[text()='End tour']";
	public static String Shop_mouseoverviewtype= "ViewType#xpath=//*[text()='View Type']";

	public static String Shop_waitfor = "mouseoverviewtype#xpath=//ul[@class='dropdown-menu dropdown-menu-less-padding dropdown-menu-round-bordered']";
	public static String Shop_tableviewText = "tableviewText#xpath=//ul[@class='dropdown-menu dropdown-menu-less-padding dropdown-menu-round-bordered']/li[1]";
	public static String Shop_tableviewIdentifier = "tableviewIdentifier#xpath=//*[@id='isotopeContainer']";
	public static String Shop_tableview = "tableview#xpath=//*[contains(text(),'Table')]";

	//public static String Shop_gridViewText = "gridViewText#xpath=//ul[@class='dropdown-menu dropdown-menu-less-padding dropdown-menu-round-bordered']/li[2]";
	public static String Shop_gridView = "gridView#xpath=//*[contains(text(),'Grid')]";
	public static String Shop_layoutshover = "layoutshover#xpath=//*[@class='dropdown-submenu pull-left ng-scope']";
	public static String Shop_userlayout = "layoutshover#xpath=//li[@class='dropdown-submenu pull-left ng-scope']/ul/";

	public static String Shop_selectmatchdropdown = "selectmatchdropdown#xpath=//*[@id='matchselect']";
	public static String Shop_elementwithcross ="elementwithcross#xpath=//*[@ng-if='currentUser.user.id == layout.created_by])";
	public static String Shop_waitforelements ="Shop_waitforelements#xpath=//*[@class='col-sm-18 ng-scope']";
	public static String Shop_countoffacilities ="Shop_countoffacilities#xpath=//*[@style='border-right: none;vertical-align: middle;']";
	public static String Shop_countofitems ="Shop_countofitems #xpath=//tr[@ng-repeat='data in $ctrl.selectList | orderBy:'name' | filter: { name:search.searchKeyword } | offset: (search.currentPage - 1) * search.iPerPage | limitTo: search.iPerPage']/span";
	public static String Shop_VendorSelect = "VendorSelect#xpath=//*[@id='vendor']";	 
	//Manage Inventory
	public static String manageInventory_waitforelements ="waitforelements#xpath=//*[@ng-repeat='item in items']";

	public static String Shop_drilldownCreateLayout = "drilldownCreateLayout#xpath=//a[text()='Create New Layout']";
	public static String Shop_drilldownChangeLayout = "drilldownChangeLayout#xpath=//ul[@class='dropdown-menu dropdown-menu-right dropdown-menu-less-padding']//a[text()='Change Current Layout']";
	public static String Shop_drilldownLayoutNameText = "drilldownLayoutNameText#xpath=//label[text()='Layout Name']/../div/input";
	public static String Shop_drilldownCreateLayoutSave = "drilldownCreateLayoutSave#xpath=//*[@class='modal-footer']/button[text()='Save']";
	public static String Shop_drilldownChangeLayoutPopup = "drilldownChangeLayoutPopup#xpath=//span[text()='Configure Shop Layout ---automation layout---']";
	public static String Shop_drilldownChangeLayoutClose = "drilldownChangeLayoutClose#xpath=//button[@class='close']";
	//public static String Shop_drilldownRemoveLayout = "drilldownRemoveLayout#xpath=//a[contains(text(),'"+layout+"')]/../i";
	public static String Shop_drilldownLayouts = "drilldownLayouts#xpath=//a[text()='Layouts']";
	public static String Shop_drilldownRemoveLayoutYes = "drilldownRemoveLayoutYes#xpath=//button[@class='confirm']";
	public static String Shop_changeLayoutTextPopUP= "changeLayoutTextPopUP=#xpath=//*[@class='headtext']/span";
	public static String Shop_wait2= "Shop_wait=#xpath=//*[@id='ng-view']";
	
	//*[@ng-repeat='item in items']

	// Dashboard Page
	public static String DashBoard_AdminDropdown = "DropDown_Admin#xpath=//admin-menu/a";
	public static String DashBoard_Report_Montly = "Report_Month#xpath=//*[@class='current-day-year ng-binding']";
	public static String DashBoard_Report_Monthly_Dolors = "Report_Montly_Dolors#xpath=(//*[@class='current-day-temperature ng-binding'])[1]";
	public static String DashBoard_Report_Monthly_txt = "Report_Monthly_txt#xpath=(//*[@class='current-day-date']/span)[1]";
	public static String DashBoard_Report_PartialReviews = "PartialReviews#xpath=(//*[@class='current-day-temperature ng-binding'])[2]";
	public static String DashBoard_Report_PartialReviews_txt = "PartialReviews_txt#xpath=(//*[@class='current-day-date']/span)[2]";
	public static String DashBoard_Report_Day = "Day#xpath=(//*[@class='current-days ng-binding'])[1]";
	public static String DashBoard_Report_Day_txt = "DayText#xpath=(//*[@class='current-days_2'])[1]";
	public static String DashBoard_Report_Hours = "Hours#xpath=(//*[@class='current-days ng-binding'])[2]";
	public static String DashBoard_Report_Hours_txt = "hoursText#xpath=(//*[@class='current-days_2'])[2]";
	public static String DashBoard_Report_avgventor_txt = "avgventorText#xpath=(//*[@class='current-day-date']/span)[3]";
	public static String DashBoard_Report_RecentOrder_txt = "Txt_recentorder#xpath=//*[text()='Recent Orders']";
	public static String DashBoard_Report_NewsEvent_txt = "Txt_NewsEvent#xpath=//*[text()='News & Events']";
	public static String DashBoard_Report_NewsDate = "NewsDate#xpath=//*[@class='newsicon in-active']";
	public static String DashBoard_Report_NewsTime = "NewsTime#xpath=//*[@class='news-time ng-binding']";
	public static String DashBoard_Report_News = "News#xpath=(//*[@class='news-sub-teaser']//p)[1]";
	public static String DashBoard_Report_News_Header = "NewsHeader#xpath=//*[@class='pagehead']";
	public static String DashBoard_Report_Newstitle1 = "NewsTitle#xpath=(//*[@class='news-sub-head ng-binding'])[1]";
	public static String DashBoard_Report_NewsPage_title1 = "NewsTitle1#xpath=(//h5)[1]";
	public static String Admin_ItemCatalog = "ItemCatalog#xpath=//a[@href='#/items-catalog']";

	// Item Catalog
	public static String Shop_ItemNameDropDown_First = "DropDown#xpath=(//*[@id='optionMenu']//*[@class='fa fa-chevron-down'])[1]";																																							 
	public static String Shop_ItemNameDropDown_two = "ItemNameDropDown#xpath=(//*[@id='optionMenu']//*[@class='fa fa-chevron-down'])[2]";
	public static String Shop_ItemNameDropDownPricechangeHistory_First = "ItemNameDropDownPriceHistory#xpath=(//*[@class='dropdown-menu']//*[text()='Price Change History'])[1]";
	public static String Shop_ItemNameDropDownPurchaceHistory_First = "ItemNameDropDownPurchaceHistory#xpath=(//*[@class='dropdown-menu']//*[text()='Purchase History'])[1]";
	public static String Shop_ItemNameDropDownEdit_First = "ItemNameDropDownEdit#xpath=(//a[@ng-show='canBeEdit'])[1]";
	public static String Shop_ItemName_StockDropdown = "StockDropdown#xpath=//select[@ng-model='v.facilityItemVendors.stock_status']";
    	
	public static String Shop_Match_Text = "Match_Text#xpath=//*[@for='matchselect']";
	public static String Shop_Item_Qty_First = "Qty#xpath=(//*[@ng-click='item.qty=getCartItem(item.item_vendor_id).qty; textBtnForm.$show();'])[1]";										
    public static String Shop_Item_Qty_Increase_First = "Qty_Increase#xpath=(//*[@ng-click='incrementQty(getCartItem(item.item_vendor_id).id)'])[1]";										
    public static String Shop_Item_Qty_Derease_First = "Qty_Degrease#xpath=(//*[@ng-click='decrementQty(getCartItem(item.item_vendor_id).id)'])[1]";										
    public static String Shop_SHopfor_Search_Addtocart_First= "Search_Addtocart_First#xpath=(//*[@ng-click='$ctrl.addItemToCart(item)'])[1]";
    public static String Shop_SHopfor_Search_Input_First1= "InputQty#xpath=(//*[@editable-text='item.qty']/nobr/span)[1]";
    public static String Shop_SHopfor_Search_Addtocart_InputQty= "InputQtyEnter#xpath=//*[@class='editable-controls form-group']/input";
    public static String Shop_checkout= "Shop_checkout#xpath=//*[@class='pull-right']//button[@ng-click='gotoCart()']";

    public static String ItemTabVendor="TabVendor#xpath=//*[@heading='Vendors']//a[text()='Vendors']";
	public static String ItemCatalog_statusDropdown="statusDropdown#xpath=//*[@id='status']";
	public static String ItemCatalog_searchbutton="searchbutton#xpath=//button[text()='Search']";
	public static String ItemCatalog_waitforeditbuttonclass="waitforeditbuttonclass#xpath=//*[@class='btn btn-primary ng-scope']"; 
	public static String ItemCatalog_inactiveitem="inactiveitem#xpath=//*@id='itemmasterListing']/tr/span";
	public static String ItemCatalog_AddPage_AddItemText = "AddItemText#xpath=//*[text()='Add Item']";
	public static String ItemCatalog_AddPage_ItemDetails = "Txt_ItemDetails#xpath=//*[text()='Item Detail']";
	public static String ItemCatalog_AddPage_temText = "AddItemText#xpath=//*[text()='Item Detail']";
	public static String ItemCatalog_AddItem = "Btn_AddItem#xpath=//button[contains(text(),'Add Item')]";
	public static String ItemCatalog_firstItemDesc ="firstItemDesc#xpath=(//*[@class='item-description']/span)[1]";
	public static String ItemCatalog_VendorTabDrillDownIcon ="VendorTabDrillDownIcon#xpath=//*[@class='btn-group']";
	//public static String ItemCatalog_CWIDLink ="CWIDLink#xpath=//*[contains,(text(),'Add CWID')]";
	public static String ItemCatalog_MApFac_UpdatePriceButton="MApFac_UpdatePriceButton#xpath=(//*[@ng-click='manageItemVendorFacility(vendor)'])[1]";
	public static String ItemCatalog_headTextEDit_Update = "headTextEDit_Update#xpath=//*[@class='modal-header']";	
	public static String ItemCatalog_EditItem ="EditItem#xpath=(//*[@ng-click='addEditItem(item.id)'])[1]";
	public static String ItemCatalog_firstItemSku ="firstItemSku#xpath=//*[@class='vendor_info']//span[@class='text-with-tooltip ng-binding']";
	public static String ItemCatalog_firstItemMfr ="firstItemMfr#xpath=//*[@class='vendor_info ng-scope']//span[@class='ng-binding']";
	public static String ItemCatalog_wait="wait#xpath=//*[@id='itemmasterListing']";
	public static String ItemCatalog_AddItem_ItemDetails_Description = "ItemDetails_Description#xpath=//*[@id='desc']";
	public static String ItemCatalog_AddItem_ItemDetails_label_Description = "Description#xpath=//*[text()='Description*']";
	public static String ItemCatalog_AddItem_ItemDetails_alias = "ItemDetails_alias#xpath=//*[@id='alias']";	
	public static String ItemCatalog_AddItem_ItemDetails_Label_alias = "alias#xpath=//label[text()='Alias']";
	public static String ItemCatalog_AddItem_ItemDetails_MfrDetails = "ItemDetails_MfrDetails#xpath=//*[@id='mfr']";
	public static String ItemCatalog_AddItem_ItemDetails_Label_Manufacture= "Manufacture#xpath=//label[text()='Manufacturer*']";
	public static String ItemCatalog_AddItem_ItemDetails_MfrDetailsDropdown = "ItemDetails_MfrDropdown#xpath=//*[@class='input-group-btn']/button";
	public static String ItemCatalog_AddItem_Man_Select = "ManSelect#xpath=(//*[@ng-click='save(manufacturer.id, manufacturer.name)'])[2]";
	public static String ItemCatalog_AddItem_LabelManufacturers = "Manufacturers#xpath=//*[contains(text(),'Manufacturers')]";
	public static String ItemCatalog_AddItem_Man_Save = "Save#xpath=//*[@type='submit']";
	public static String ItemCatalog_AddItme_TestId = "TestId#xpath=//*[@id='item_identifier']";
	public static String ItemCatalog_Vendors = "Vendors#xpath=//a[contains(text(),'Vendors')]";
	public static String ItemCatalog_QualityinStock = "QualityinStock#xpath=//*[text()='Quantity in Stock ']";
	public static String ItemCatalog_VendorsTab = "VendorsTab#lnktext=Vendors";
	public static String ItemCatalog_gpo = "gpo#xpath=//*[@class='v.facilityItemVendors.gpo_contract_price']";
	public static String ItemCatalog_AddVendors = "AddVendors#xpath=//input[@value='Add Vendor']";
	public static String ItemCatalog_Add_Vendorsname = "Vendorsname#xpath=//*[@name='vendor_name']";
	public static String ItemCatalog_Add_Vendorsname1 = "Vendorsname#xpath=(//*[@name='vendor_name'])[2]";
	public static String ItemCatalog_Add_VendorsnameSelect = "VendorsnameSelect#xpath=//table[@id='tbl_add_vendor1']/tbody/tr/td[4]/select";
	public static String ItemCatalog_firstvendor = "firstvendor#xpath=//*[@id='tbl_add_vendor1']/tbody/tr[1]/td[2]/div[1]/div/span/span[2]/span";
	public static String ItemCatalog_itemCategory = "itemCategory#xpath=//select[@ng-model='item.category_id']";
	public static String ItemCatalog_itemalias = "itemalias#xpath=//*[@id='alias']";
	public static String ItemCatalog_itemCategoryfirstItem = "itemCategoryfirstItem#xpath=//select[@ng-model='item.category_id']/option[2]";
	public static String ItemCatalog_searchTextBox = "searchTextBox#xpath=//*[@id='PONUM']";
	public static String ItemCatalog_searchButtoncommon = "searchButtoncommon#xpath=(//button[text()='Search'])[1]";
	public static String ItemCatalog_firstEDitButton = "firstEDitButton#xpath=(//*[@ng-click='addEditItem(item.id)'])[1]";
	public static String ItemCatalog_firstitemName = "firstitemName#xpath=(//*[@class='item-description'])[1]";
	public static String ItemCatalog_FileUpload = "FileUpload#xpath=(//*[@type='file'])[1]";
	public static String ItemCatalog_FileUpload_Remove_First = "Removefirst#xpath=(//button[text()='Remove'])[1]";
	public static String ItemCatalog_FileUpload_FirstImg = "FirstImg#xpath=(//img)[1]";
	public static String ItemCatalog_FileUpload_CloseBtn = "CloseBtn#xpath=//button[text()='Close']";
	
	// Invoice 
	public static String Invoice_VendorDropdown = "Vendordropdown#xpath=//*[@name='vendor_name']//*[@class='ui-select-match-text pull-left']";
	public static String Invoice_statusDropdown = "Statusdropdown#xpath=//*[@name='status']//*[@class='ui-select-match-text pull-left']";
	public static String Invoice_FromDate = "FromDate#xpath=//*[@id='day']";
	public static String Invoice_ToDate = "ToDate#xpath=//*[@id='to']";
	public static String Invoice_FromDate_calander = "FromDateCalander#xpath=(//*[@class='glyphicon glyphicon-calendar'])[1]";
	public static String Invoice_ToDate_calander = "ToDateCalander#xpath=(//*[@class='glyphicon glyphicon-calendar'])[2]";
	public static String Invoice_Print_Invoice = "Invoice#xpath=//*[text()='INVOICE']";
	
	
	// Vendor
	public static String ItemCatalog_Vendort_IsActive = "IsActive#xpath=//*[text()='Is Active']";
	public static String ItemCatalog_Vendort_VendorName = "VendorName#xpath=//*[contains(text(),'Vendor Name')]";
	public static String ItemCatalog_Vendort_SKU = "Sku#xpath=//*[contains(text(),'SKU')]";
	public static String ItemCatalog_Vendort_UOM = "UOM#xpath=(//*[contains(text(),'UOM')])[1]";
	public static String ItemCatalog_Vendort_QTYUOM = "QTYUOM#xpath=(//*[contains(text(),'Qty in UOM')])[1]";
	public static String ItemCatalog_Vendort_MinORder = "MinORder#xpath=//*[text()='Min Order Qty.']";
	
	
	
	
	// public static String ItemCatalog_Add_allvendorsfromdropdown = "VendorsnameSelect#xpath=//table[@id='tbl_add_vendor1']/tbody/tr/td[4]/select";
	public static String ItemCatalog_Add_VendorsSkuName ="VendorsSkuName#xpath=//input[@ng-model='v.sku']";
	public static String ItemCatalog_Add_VendorsSkuName1 ="VendorsSkuName#xpath=(//input[@ng-model='v.sku'])[2]";
	public static String ItemCatalog_Add_VendorsMinOrderQty = "VendorsMinOrderQty#xpath=//input[@ng-model='v.min_order_qty']";
	public static String ItemCatalog_Add_VendorsMinOrderQty1 = "VendorsMinOrderQty#xpath=(//input[@ng-model='v.min_order_qty'])[2]";
	public static String ItemCatalog_AddItem_MapValidation = "MapValidation#xpath=//*[contains(text(),'Do you want to map this item to your various facilities?')]";
	public static String ItemCatalog_AddItem_MapValidation_Cancel = "Cancel#xpath=//*[@class='cancel']";
	public static String ItemCatalog_AddItem_MapValidation_yes = "MapValidation_Yes#xpath=//*[@class='confirm']";
	public static String ItemCatalog_AddItem_VendorSelect_First = "VendorSelect_First#xpath=(//*[@ng-bind-html='vendor.name | highlight: $select.search'])[2]";
	public static String ItemCatalog_SaveButton ="SaveButton#xpath=//*[@type='submit']";
	public static String ItemCatalog_Similaritem ="SimilarItem#xpath=(//*[text()='similar item'])[1]";
	public static String ItemCatalog_MapfacilityButton ="MapfacilityButton#xpath=(//*[contains(text(),'Map Facility/Update Price')])[2]";
	public static String ItemCatalog_mapallbuttontopright ="mapallbuttontopright#xpath=//*[contains(text(),'More Options')]";
	public static String ItemCatalog_mapwithalltopright ="mapwithalltopright#xpath=//a[text()='Map with all facility']";
	public static String ItemCatalog_Map_changeForMoreFacility ="changeForMoreFacility#xpath=//*[text()='Change for mapped facilities']";
	public static String ItemCatalog_Map_PurchasePrice ="PurchasePrice#xpath=//label[text()='Purchase Price']";
	public static String ItemCatalog_Map_StockPrice ="StockPrice#xpath=//label[text()='Stock Status']";
	public static String ItemCatalog_Map_DiscountType ="Discounttype#xpath=//label[text()='Discount type']";
	public static String ItemCatalog_Close ="Close#xpath=(//button[@class='close'])[1]";
	public static String ItemCatalog_Replace_Btn="Replace#xpath=//*[@class=\"fa fa-shopping-cart\"]/following-sibling::text()[contains(., 'Replace')]";
	
	
	public static String ItemCatalog_verifytextpopup ="verifytextpopup #xpath= //*[@class='modal-header']/div/span";
	public static String ItemCatalog_purchaseprice ="purchaseprice#xpath= //input[@ng-model='purchase_price']";
	public static String ItemCatalog_purchase_price_Edit ="purchaseprice#xpath= //*[@ng-model='v.facilityItemVendors.purchase_price']";
	public static String ItemCatalog_GPo_price_Edit ="Gpoprice#xpath= //*[@ng-model='v.facilityItemVendors.gpo_contract_price']";
	//public static String ItemCatalog_mapallbutton ="mapallbutton#xpath=//button[@type='submit']";
	public static String ItemCatalog_mapallbutton ="mapallbutton#xpath=//button[@id='btnAdd']";
	public static String ItemCatalog_txt_Addmanufacture ="AddmanufactureTxt#xpath=//*[text()='Add Manufacturer']";
	public static String ItemCatalog_txt_Addmanufacture_labelName ="labelName#xpath=//label[text()='Name*']";
	public static String ItemCatalog_txt_Addmanufacture_Name ="Name#xpath=//*[@id='name']";
	public static String ItemCatalog_txt_Addmanufacture_Notes ="Notes#xpath=//label[text()='Notes ']";
	public static String ItemCatalog_txt_Addmanufacture_LotTracking ="LotTracking#xpath=//label[text()='Lot # Tracking ']";
	public static String ItemCatalog_additem_LotTracking_toogle ="LotTracking#xpath=//*[contains(text(),'Lot # Tracking')]/following-sibling::div/div";
	public static String ItemCatalog_additem_Active_toogle ="ActiveTracking#xpath=//*[contains(text(),'Active')]/following-sibling::div/div";
	public static String ItemCatalog_additem_Expiration_toogle ="Expiration#xpath=//*[contains(text(),'Expiration Tracking')]/following-sibling::div/div";
	public static String ItemCatalog_additem_Bill_Only_toogle ="Bill_Only#xpath=//*[contains(text(),'Bill Only')]/following-sibling::div/div";
	public static String ItemCatalog_additem_Implant_toogle ="Implant#xpath=//*[contains(text(),'Implant')]/following-sibling::div/div";
	public static String ItemCatalog_additem_Is_Service_toogle ="Is_Service#xpath=//*[contains(text(),'Is Service')]/following-sibling::div/div";
	public static String ItemCatalog_additem_GLcode_dropdown ="GLcode_ropdown#xpath=//label[contains(text(),'Gl Codes')]/following-sibling::div//*[@class='ui-select-match ng-scope']";
	public static String ItemCatalog_additem_Categories_dropdown ="Categories_dropdown#xpath=//label[contains(text(),'Categories')]/following-sibling::div/select";
	public static String ItemCatalog_additem_CPTCOde_Input ="CPTCOde_Input#xpath=//*[@id='cpt_code']";
	public static String ItemCatalog_additem_hspcs_Input ="hspcs_Input#xpath=//*[@id='hspcs']";
	public static String ItemCatalog_additem_Vendors_QuickCode_label ="labelQuickCode#xpath=//label[contains(text(),'Quick Code')]";
	public static String ItemCatalog_additem_Vendors_QuickCodedropdown ="QuickCode#xpath=//a[text()='Add Quick Code']";
	public static String ItemCatalog_additem_Vendors_ManageImagedropdown ="ManageImage#xpath=//a[text()='Manage Images']";
	public static String ItemCatalog_additem_Vendors_CWIIDDdropdown ="CWIIDD#xpath=//*[@ng-click=\"show_cross_walk_id = true;addGAEvents('CrossWalkId');\"]";
	public static String ItemCatalog_additem_Vendors_QuickCode ="QuickCode#xpath=//*[@ng-model='v.quick_code']";
	public static String ItemCatalog_additem_Vendors_CWIIDD_label ="CWIIDDlabel#xpath=(//label[contains(text(),'CWIIDD')])[2]";
	public static String ItemCatalog_additem_Vendors_CWIIDD ="CWIIDD#xpath=//*[@ng-model='v.cross_walk_id']";
	public static String ItemCatalog_additem_Delete_vendor ="Delete_vendor#xpath=//button[@ng-click='deleteVendorFn($index)']";
	public static String ItemCatalog_additem_Deletevalidation ="Deletevalidation#xpath=//*[text()='At least one vendor will remain for an item.']";
	
	public static String ItemCatalog_txt_Billonly ="Billonly#xpath=//label[contains(text(),'Bill Only')]";
	public static String ItemCatalog_VendorUpdate ="VendorUpdate#xpath=//*[contains(text(),'Vendor Update')]";
	public static String ItemCatalog_DiscountType_Dropdown ="DiscountType_Dropdown#xpath=(//select[@name='discount_type'])[2]";
	public static String ItemCatalog_DiscountPercentage ="DiscountPercentage#xpath=//*[contains(text(),'Discount(%)')]";
	public static String ItemCatalog_DiscountPercentage_Input ="InputDiscountPercentage#xpath=//*[@name='discount']";
	
	public static String ItemCatalog_Mapfacility_Facility ="Facility#xpath=//a[contains(text(),'Facility')]";
	public static String ItemCatalog_Mapfacility_PurchasePrice ="PurchasePrice#xpath=//a[contains(text(),'Purchase Price')]";
	public static String ItemCatalog_Mapfacility_StockStatus ="StockStatus#xpath=//a[contains(text(),'Stock Status')]";
	public static String ItemCatalog_Mapfacility_Active ="Active#xpath=//a[contains(text(),'Active')]";
	public static String ItemCatalog_Mapfacility_GpocontactPrice ="GpocontactPrice#xpath=(//*[contains(text(),'GPO Contract Price')])[1]";
	public static String ItemCatalog_Mapfacility_Discountprice ="Discountprice#xpath=(//*[contains(text(),'Discount type')])[1]";
	public static String ItemCatalog_Mapfacility_AddtoFacility_first ="AddtoFacility_first#xpath=(//button[contains(text(),'Add to facility')])[1]";
	public static String ItemCatalog_Mapfacility_Preferred_first ="Preferred#xpath=(//*[text()='Preferred'])[1]";
	public static String ItemCatalog_Mapfacility_Distributed_first ="Distributed#xpath=(//*[text()='Distributed'])[1]";
	public static String ItemCatalog_Mapfacility_OnContract_first ="OnContract#xpath=(//*[text()='On Contract'])[1]";
	public static String ItemCatalog_Mapfacility_iSActive ="iSActive#xpath=//input[@name='is_active']";
	public static String ItemCatalog_Mapfacility_Save ="Save#xpath=(//button[contains(text(),'Save')])[1]";
	public static String ItemCatalog_Mapfacility_Cancel ="Cancel#xpath=(//button[contains(text(),'Cancel')])[1]";
	public static String ItemCatalog_Mapfacility_Stockdropdown ="Stockdropdown#xpath=(//select[@name='stock_status'])[2]";
	public static String ItemCatalog_Mapfacility_Editbtn ="Editbtn#xpath=(//button[contains(text(),'Edit')])[1]";
	public static String ItemCatalog_Mapfacility_Deletebtn ="Deletebtn#xpath=(//button[contains(text(),'Delete')])[1]";
	
	// Add item Map faility
	public static String ItemCatalog_AddItem_Map_Header = "Map_Header#xpath=//*[@class='headtext']";
	public static String ItemCatalog_AddItem_Map_SearchFacility_Text = "SearchFacilityText#xpath=//*[text()='Search Facility']";
	public static String ItemCatalog_AddItem_Map_SearchFacility ="SearchFacility#xpath=//*[@id='facility-search']";
	public static String ItemCatalog_AddItem_Map_AddFacility ="AddFacility#xpath=//*[@id='tblMapFacility']/tbody/tr[2]/td[2]/button";
	public static String ItemCatalog_AddItem_Map_PurchagePrice ="PurchagePrice#xpath=//*[@id='purchase-price0']";
	public static String ItemCatalog_AddItem_Map_GPOPurchagePrice ="GPOPurchagePrice#xpath=//*[@name='gpo_contract_price']";
	public static String ItemCatalog_AddItem_Map_GPOPurchagePriceSave ="GPOPurchagePriceSave#xpath=(//button[contains(text(),'Save')])[1]";
	public static String ItemCatalog_AddItem_Map_Closepage ="Close#xpath=//*[@class=\"headtext\"]//button[@class='close']";
	public static String ItemCatalog_Edit ="Edit#xpath=(//button[contains(text(),'Edit Item')])[1]";
	public static String ItemCatalog_downbutton ="downbutton#xpath=//*[@role='group']";
	public static String ItemCatalog_MapFacilityClose ="MapFacilityClose#xpath=//*[text()='Map with all facilities']/following-sibling::button[@class='close']";
	
	// Notification
	public static String Notification_Bell = "Bell#xpath=//*[@id='notification-count']";
	public static String Notification_First = "FirstNotification#xpath=(//*[@class='notifiy-detail ng-binding'])[1]";
	public static String Notification_First_Time = "FirstNotificationTime#xpath=(//*[@class='notifiy-time ng-binding'])[1]";
	public static String Notification_ViewAll = "ViewAll#xpath=//*[@id='all-notifications']/a";
	public static String Notification_Mynotification = "Mynotification#xpath=//*[contains(text(),'My NOTIFICATIONS')]";
	public static String Notification_Btn_Refresh = "BtnRefresh#xpath=//*[text()='Refresh']";
	public static String NotficationPage_Text = "txt_Notification#xpath=//div[contains(text(),'Notification Settings')]";
	public static String NotficationPage_Text_Event = "Event#xpath=//*[text()='Event']";
	public static String NotficationPage_Text_Event_Purchase_order_Approval = "Purchase_order_Approval#xpath=//*[contains(text(),'Purchase Order Approval')]";
	public static String NotficationPage_Text_Event_Pending_Approval = "Pending_Approval#xpath=//*[contains(text(),' Pending Approval')]";
	public static String NotficationPage_Text_Event_Purchase_Order_Approved = "Purchase_Order_Approved#xpath=//*[contains(text(),'Purchase Order Approved')]";
	public static String NotficationPage_Text_Event_Purchase_Order_Confirmation = "Purchase_Order_Confirmation#xpath=//*[contains(text(),'Purchase Order Confirmation')]";
	public static String NotficationPage_Text_Event_Purchase_Order_Shipped = "Purchase_Order_Shipped #xpath=//*[contains(text(),'Purchase Order Shipped')]";
	public static String NotficationPage_Text_Event_Purchase_Order_Invoice = "Purchase_Order_Invoice#xpath=//*[contains(text(),'Purchase Order Invoice')]";
	public static String NotficationPage_Text_Event_QOH_LessThanParLevel  = "QOH_LessThanParLevel#xpath=//*[contains(text(),'QOH Less Than Par Level')]";
	public static String NotficationPage_Text_Event_Template_Schedule_Create_PO  = "Template_Schedule_Create_PO#xpath=//*[contains(text(),'Template Schedule Create PO')]";
	public static String NotficationPage_Text_Event_Purchase_Order_Rejected  = "Purchase_Order_Rejected#xpath=//*[contains(text(),'Purchase Order Rejected')]";
	public static String NotficationPage_Text_MobilePush = "txt_MobilePush#xpath=//*[text()='Mobile Push']";
	public static String NotficationPage_Text_Email = "txt_Email#xpath=//*[text()='Email Notification']";
	public static String NotficationPage_Text_Web = "txt_Web#xpath=//*[text()='Web Notification']";
	public static String NotficationPage_FirstNotificationText = "FirstNotification#xpath=(//*[@id='gridNotificationListing']//p)[1]";
	public static String NotficationPage_FirstNotificationDelete = "FirstNotificationDelete#xpath=(//a[@ng-click='deleteNotification(notificationsInfo.id)'])[1]";
	public static String NotficationPage_Save = "Save#xpath=//*[@id='submit_notification_settings']";
	public static String NotficationPage_Cancel = "Cancel#xpath=//*[@id='cancel-settings']";

	// User Setting
	public static String User = "User#xpath=//*[@class='user-cont']";
	public static String User_Profile = "Profile#xpath=//a[@href='#/user/update-profile']";
	public static String User_NotificationSetting = "NotificationSetting#xpath=//*[@href='#/notification/settings']";
	public static String User_alert = "alert#xpath=//*[@href='#/user/update-profile/alert']";
	public static String User_Survey = "Survey#xpath=//a[text()='Survey']";
	public static String User_ChangePassword = "ChangePassword#xpath=//a[text()='Change Password']";
	public static String User_SwitchUser = "SwitchUser#xpath=//*[@href='#/selectuser']";

	// My Cart
	public static String MyCart = "MyCart#xpath=//*[@href='#/my-cart']";
	public static String MyCart_count = "countMyCart#xpath=//a[@ng-href='#/my-cart']/i/sup";
	public static String MyCart_cartFor = "text_cartFor#xpath=//*[contains(text(),'Cart for')]";
	public static String MyCart_cartFor_Details = "Facility#xpath=//*[@select-list='shippingLocations']/a";
	public static String MyCart_cartFor_CartMore = "CartMore#xpath=//*[@tour-step='cart-more']/button";
	public static String MyCart_cartFor_NoElementFound = "NoElementFound#xpath=(//*[text()='No Items Found.'])[1]";
	public static String MyCart_searchInCart = "searchInCart#xpath=//*[@id='searchInput']";
	public static String MyCart_InputQty = "InputQty#xpath=//*[@ng-show='$ctrl.editQty']//big";
	public static String MyCart_InputQty_InputQtyDecrease = "InputQtyDecrease#xpath=//*[@id='dcr']";
	public static String MyCart_InputQty_InputQtyIncrease = "Increase#xpath=//*[@id='incr']";
	public static String MyCart_addItemInCart = "addItemInCart#xpath=(//*[@id='btnAdd' and text()='Add '])[1]";
	//public static String MyCart_warningPopup = "warningPopup#xpath=//*[@class='row']";
	public static String MyCart_warningPopup = "warningPopup#xpath=//button[text()='Continue']";
	public static String MyCart_useMYPO = "useMYPO#xpath=//*[@ng-click='test_check(key)']";
	public static String MyCart_continueButton = "continueButton#xpath=//button[text()='Continue']";
	public static String MyCart_firstItemName = "firstItemName#xpath=//ul[@id='suggestions']/li/div/div[1]/div/span/strong";
	public static String MyCart_firstItemNamewait = "firstItemNamewait#xpath=//ul[@id='suggestions']";
	public static String MyCart_firstItemSkuName = "firstItemSkuName#xpath=//*[@id='suggestions']/li[1]/div/div[3]/div[1]/span/small";	
	public static String MyCart_drillDown = "drillDown#xpath=//button[@class='btn btn-default dropdown-toggle' and @type='button']";
	
	public static String MyCart_drillDownDiv = "drillDownDiv#xpath=//*[@class='btn-group pull-right ng-scope' and @role='group']";

	public static String MyCart_clearCurrentCart = "clearCurrentCart#xpath=//a[contains(text(),'Clear Current Cart')]";
	public static String MyCart_yesInPopup = "MyCart_yesInPopup#xpath=//button[contains(text(),'Yes')]";
	public static String MyCart_OKInPopup = "OKInPopup#xpath=//button[contains(text(),'OK')]";
	public static String MyCart_clearAllCarts = "clearAllCart#xpath=//a[contains(text(),'Clear Current Cart')]";
	//public static String MyCart_qtyOfItemBeforeAfter = "qtyOfItemBeforeAfter#xpath=//*[@id='ng-view']/div/div/div[3]/div/div/div/table/tbody[1]/tr[3]/td[3]/div/span";
	public static String MyCart_qtyOfItemBeforeAfter = "qtyOfItemBeforeAfter#xpath=//*[@class='fix_qty pull-right']//big";
	public static String MyCart_plusIcon = "plusIcon#xpath=//button[@id='incr']";
	public static String MyCart_minusIcon = "minusIcon#xpath=//button[@id='dcr']";
	public static String MyCart_editItemQty = "editItemQty#xpath=//*[@editable-text='cartItem.newQty']//*[@class='item-qty-editable-label ng-binding']";
	public static String MyCart_editItemQtyTextBox = "editItemQtyTextBox#xpath=//div[@class='editable-controls form-group']/input";      
	public static String MyCart_submitQty = "submitQty#xpath=//button[@title='Submit']";
	public static String MyCart_cancelQty = "cancelQty#xpath=//button[@title='Cancel']";
	public static String MyCart_SiTextBox = "SiTextBox#xpath=//input[@class='cart-comment-box-without-value text-primary ng-pristine ng-untouched ng-valid']";
	public static String MyCart_UsemyPOCheckBox = "UsemyPOCheckBox#xpath=//*[@ng-click='test_check(key)']";
	public static String MyCart_typePONumber = "typePONumber #xpath=//*[@ng-show='checked_pos[key].show']//*[@class='form-control ng-pristine ng-valid ng-valid-maxlength ng-touched input-sm ng-untouched ng-empty']";
	public static String Mycard_GenderFor ="Genderfor#xpath=//*[contains(text(),'Generate for')]";
	public static String Mycard_GenderFor_vendor ="Vendoe#classname=vendor-bubble-left";
	public static String MyCart_drillDownVendor = "drillDownVendor#xpath=//tr//*[@class='container-fluid']//*[@id='optionMenu']";
	public static String MyCart_removeVendor = "removeVendor#xpath=//*[contains(text(), 'Remove Vendor from Cart')]";   
	public static String MyCart_removeVendor_validation = "removeVailication#xpath=//*[text()=\"Are you sure you want to remove this vendor's items from cart?\"]";
	public static String MyCart_confirmButton = "confirmButton#xpath=//button[@class='confirm']";
	public static String MyCart_accountSetUp = "MyCart_accountSetUp#xpath=//*[contains(text(), 'Account setup')]"; 
	public static String MyCart_Checkaccount = "check_account#xpath=//*[contains(text(), \"Check Item's Availability\")]";
	public static String MyCart_emptycartText = "MyCart_emptycartText#xpath=//*[@class='table']/tbody/tr/td/h3";
	public static String MyCart_ItemReorder = "ItemReorder#xpath=//*[@class='modal-title']/i/following-sibling::text()";
	public static String MyCart_AttachPhycian = "AttachPhycian#xpath=//*[contains(text(),'Attach Physician')]";
	public static String MyCart_AttachPhycian_Physicians_title= "Physicians#xpath=//h4[text()='Physicians']";

	public static String MyCart_AddDepartmenthyperLink = "AddDepartmenthyperLink#xpath=//a[@ng-click='selectDepartments(cartItem);']";
	public static String MyCart_AddDepartmentText = "AddDepartmentText#xpath=(//h4)[1]";
	public static String MyCart_AddDepartmentPopUPcancel = "_AddDepartmentPopUPcancel #xpath=//*[@class='close']";
	public static String MyCart_AddPhysicianhyperLink = "AddPhysicianhyperLink#xpath=//a[@ng-click='selectPhysicians(cartItem);']";
	public static String MyCart_AddPhysicianText = "AddPhysicianText#xpath=(//h4)[1]";
	public static String MyCart_PrintPO= "PrintPO#xpath=//a[@ng-click='showPopUp()']";
	public static String MyCart_PrintPOPopUpText= "PrintPOPopUpText#xpath=//*[@class='modal-content ng-scope']/div/div/span";
	public static String MyCart_PrintCloseclose="PrintPReviewclose#xpath=//*[@class='fa fa-2x fa-times']";
	
	public static String MyCart_showTourButton= "showTourButton#xpath=//a[@ng-click='startTour();']";
	public static String MyCart_showtourtextONPOPUP="showtourtextONPOPUP#xpath=//h3[contains(text(),'Cart: List of Items')]";
	public static String MyCart_cartIconNumber="cartIconNumber#xpath=//*[@href='#/my-cart']/i/sup";
	public static String MyCart_clearAllCarts2 = "clearAllCarts#xpath=//*[@ng-click='clearCart()']";	
	public static String MyCart_Receiveonly = "Receiveonly#xpath=//*[text()='Receive Only']";
	public static String MyCart_Consignment = "Consignment#xpath=(//*[text()='Is Consignment'])[1]";
	public static String MyCart_ReceiveonlyCheckbox = "Receiveonly#xpath=//*[text()='Receive Only']/preceding-sibling::input";
	public static String MyCart_usePo = "UsePo#xpath=//*[@ng-model='checked_pos[key].check']";
	public static String MyCart_usePo_value = "UsePo#xpath=//*[@ng-model='checked_pos[key].val']";
	public static String MyCart_Sku = "Sku#xpath=//*[@ng-click=\"order('itemVendor.sku')\"]";
	public static String MyCart_Qty = "Qty#xpath=//*[@ng-click=\"order('qty')\"]";
	public static String MyCart_UOM = "UOM#xpath=//*[@ng-click=\"order('itemVendor.UOM')\"]";
	public static String MyCart_status = "UOM#xpath=//*[@ng-click=\"order('facilityItemVendor.stock_status')\"]";
	public static String MyCart_Price = "Price#xpath=//*[@ng-click=\"order('facilityItemVendor.purchase_price')\"]";
	public static String MyCart_Price1 = "Price#xpath=(//*[@ng-click='$ctrl.setItemPrice()()'])[1]";
	public static String MyCart_Price_updateprice = "UpdatepricePrice#xpath=//*[contains(text(),'Update Item Price')]";
	public static String MyCart_TotalPrice = "TotalPrice#xpath=//*[@ng-click=\"order('itemVendor.v_total_price')\"]";
	public static String MyCart_UpdatePrice = "UpdatePrice#xpath=//*[@ng-model='itemForm.price']";
	public static String MyCart_CurrentPrice = "CurrentPrice#xpath=//*[text()='Current Price']";
	public static String MyCart_Grandtotal = "Grandtotal#xpath=//*[text()='Grand Total']/following-sibling::td[1]";
	public static String MyCart_GeneratePo = "GeneratePo#xpath=//*[@id='btnAdd' and contains(text(),'Generate PO')]";
	public static String MyCart_GeneratePoNumber = "PONumber#xpath=//*[@ng-show='checked_pos[key].show']/input";
	public static String MyCart_BackOrder = "BackOrder#xpath=//*[text()='Back Ordered']";
	public static String MyCart_SpecialInstruction = "SpecialInstruction#xpath=(//hyb-special-instructions//input[2])[1]";
	public static String MyCart_Save = "Save#xpath=//*[contains(text(),'Save')]";
	public static String MyCart_PO_text = "PO#xpath=//*[@ng-model='checked_pos[key].check']/following-sibling::text()";
	public static String MyCart_YourcartEmpty = "YourCartEmpty#xpath=//*[text()='Your cart is Empty']";
	
	// Profile
	public static String Profile_UserProdile = "UserProfile#xpath=//span[text()='User Profile']";
	public static String Profile_Btn_Update = "Btn_Update#xpath=//button[text()='Update']";
	public static String Profile_Btn_cancel = "Btn_Cancel#xpath=//*[@value='Cancel']";
	public static String Profile_Label_Name = "Label_Name#xpath=//*[@for='name']";
	public static String Profile_Label_Email = "Label_email#xpath=//*[@for='email']";
	public static String Profile_Label_phone = "Label_phone#xpath=//*[@for='phone']";
	public static String Profile_Label_Photo = "Label_Photo#xpath=//*[@for='pic']";
	public static String Profile_Label_Facility = "Label_Facility#xpath=//label[text()='Facility']";
	public static String Profile_Label_Dept = "Label_Dept#xpath=//label[text()='Department:']";
	public static String Profile_Label_Inventory = "Label_Inventory#xpath=//label[text()='Inventory']";
	public static String Profile_Label_Journeydate = "Label_Journeydate#xpath=//label[text()='Joining Date:']";
	public static String Profile_Label_QuickBook = "Label_QuickBook#xpath=//label[text()='Quick Books:']";
	public static String Profile_userEmail="userEmail#xpath=//*[@id='email']";

	// Alert
	public static String Alert_txt_userAlert = "txt_userAlert#xpath=//span[text()='User Alert']";
	public static String Alert_Btn_Update = "Btn_Update#xpath=//button[text()='Update']";
	public static String Alert_Btn_cancel = "Btn_Cancel#xpath=//*[@value='Cancel']";

	// Survey
	public static String Survey_txt_Survey = "txt_survey#xpath=//*[@class='headtext']/span";
	public static String Survey_btn_Clickhere = "btn_Clickher#xpath=//button[text()='Click here to start!']";

	// change password
	public static String Cpwd__Header ="changepassword_Header#xpath=//*[@class='headtext' and text()='Change Password']";
	public static String Cpwd_txt_changepassword = "txt_changepassword#xpath=//div[contains(text(),'Change Password')]";
	public static String Cpwd_txt_oldpassword = "txt_oldpassword#xpath=//*[@for='oldPassword']";
	public static String Cpwd_txt_newpassword = "txt_newpassword#xpath=//*[@for='newPassword']";
	public static String Cpwd_txt_confirmpassword = "txt_confirmpassword#xpath=//*[@for='confirmPassword']";
	public static String changepassword_Input_oldPwd ="oldPwd#xpath=//*[@id='oldPassword']";
	public static String changepassword_Input_newPwd ="newPwd#xpath=//*[@id='newPassword']";
	public static String changepassword_Input_confirmPassword ="confirmPassword#xpath=//*[@id='confirmPassword']";
	public static String Cpwd_btn_submit = "Btn_Submit#xpath=//*[@type='submit']";
	public static String Cpwd_sucesschanged ="sucesschanged#xpath=//*[contains(text(),'Your password is updated successfully.')]";
	public static String Cpwd_okay ="sucesschangedokay#xpath=//button[@class='confirm']";

	// Switch User
	public static String SwitchUser_txt_Msg = "Selectuser#xpath=//*[text()='Select user to login']";

	// Report
	public static String ViewMoreReport = "ViewReport#xpath=//*[contains(text(),'View More Reports')]";

	//manage Inventory
	public static String manageInvenLink = "manageInvenLink#xpath=//a[@href='#/inventory']";
	public static String manageInven_Print = "Print#xpath=//*[@uib-tooltip='Print']";
	public static String manageInven_PrintPriview = "PrintPriview#xpath=//button[contains(text(),'Print Preview')]";
	public static String manageInven_PrintPriview_printsheet = "PrintSheet#xpath=//*[text()='Print sheet With :']";
	public static String manageInven_PrintPriview_CWID = "CWID#xpath=//*[text()='CWID']";
	public static String manageInven_Transfer = "Transfer#xpath=//*[@uib-tooltip='Transfer']";
	public static String manageInven_Transfer_Header = "Transfer_Header#xpath=//*[text()='Transfer Inventory']";
	public static String manageInven_Transfer_InventoryLabel = "Inventorylabel#xpath=//*[text()='Transfer From Inventory*']";
	public static String manageInven_Transfer_Inventory = "Inventory#xpath=//*[@ng-transclude='']";
	public static String manageInven_Transfer_QuantityInventory = "QuantityInventory#xpath=//*[text()='Quantity In Inventory']";
	public static String manageInven_Transfer_Stock = "Stock#xpath=//hyb-tracking-info";
	public static String manage_stsusDropdwn = "manage_stsusDropdwn#xpath=//*[@id='status']";
	public static String Inventory = "Inventory#xpath=//*[@id='inventory1']";
	public static String manage_searchButton = "searchButton#xpath=//button[text()='Search']";
	public static String manage_inactiveitem= "inactiveitem#xpath=//*[@class='item-description']/span";
	public static String manage_wait= "wait#xpath=//*[@id='itemmasterListing']";
	public static String manage_categoryt= "category#xpath=//*[@id='category']";
	public static String manage_PDF_close = "close#xpath=//*[@size='xl']//button[@class='close']";
	
	//Request PO
	public static String Request_MenuLink = "MenuLink#xpath=//a[@href='#/service-request/create']";
	public static String Request_ServiceLocation_dropdown = "ServiceLocation#xpath=//*[@id='shippingLocation']";
	public static String Request_ServiceDate_dropdown = "ServiceDate#xpath=//*[@id='txtExpectedDate']";
	public static String Request_ServiceLocation = "ServiceLocation#xpath=//*[@id='shippingLocation']";
	public static String Request_Hash = "Hash#xpath=//th/a[contains(text(),'#')]";
	public static String Request_Item = "Item#xpath=//th/a[contains(text(),'Item')]";
	public static String Request_SKU = "SKU#xpath=//th/a[contains(text(),'SKU')]";
	public static String Request_QTY = "QTY#xpath=//th/a[contains(text(),'QTY.')]";
	public static String Request_UOM = "UOM#xpath=//th/a[contains(text(),'UOM')]";
	public static String Request_Durationtxt = "Duration#xpath=//th/a[contains(text(),'Duration')]";
	public static String Request_calander = "Calender#xpath=//*[@class='glyphicon glyphicon-calendar']";
	public static String Request_calander_Value = "CalenderValue#xpath=//*[@ng-click='toggleMode()']";
	public static String Request_calander_SelectDate = "SelectDate#xpath=//button/span[@class='ng-binding' and text()='01']";
	public static String Request_Price = "Price#xpath=(//th/a[contains(text(),'Price')])[1]";
	public static String Request_DiscountedPrice = "DiscountedPrice#xpath=//th/a[contains(text(),'Discounted Price')]";
	public static String Request_TotalPrice = "TotalPrice#xpath=//th/a[contains(text(),'Total Price')]";
	public static String Request_DropDown = "DropDown#xpath=//*[@class='pagehead']//*[@data-toggle='dropdown']";
	
	public static String Request_pageDoesnotExist="pageDoesnotExist#xpath=//*[@class='sweet-alert showSweetAlert visible']//h2";
	public static String Request_drillDown = "Request_drillDown#xpath=//*[@class='pagehead']//*[@data-toggle='dropdown']";
	public static String Request_createNewService = "createNewService#xpath=//*[contains(text(),'Add New Service')]";
	public static String Request_PrintItems = "PrintItems#xpath=//*[contains(text(),'Print Items')]";
	public static String Request_PrintItems_sku = "Sku#xpath=//*[text()='SKU']";
	public static String Request_Addemail = "AddEmail#xpath=//*[@ng-click='addNew()']";
	public static String Request_x = "x#xpath=(//*[contains(text(),'×')])[1]";
	public static String Request_PODElay = "PODElay#xpath=//*[text()='PO Delay']";
	public static String Request_newemail = "newEmail#xpath=//*[@id='new_email']";
	public static String Request_addNewEmail = "addNewEmail#xpath=//*[@ng-click='addNewEmail()']";
	public static String Request_GeneratePo = "GeneratePo#xpath=//button[contains(text(),'Generate PO')]";
	public static String Request_PrintItems_GenerateServicePo = "GenerateServicePo#xpath=//*[text()='Generate Service PO']";
	public static String Request_SendpoPDF = "SendpoPDF#xpath=(//*[@ng-model='servicePO.option'])[1]";
	public static String Request_Emailfield = "EmailField#xpath=//*[@on-select='emailSelected($item)']";
	public static String Request_Printpo = "Printpo#xpath=(//*[@ng-model='servicePO.option'])[2]";
	public static String Request_RequestService = "RequestService#xpath=//*[@id='btnAdd' and contains(text(),'Request Service')]";
	public static String Request_PrintItems_MFRNumber = "MFRNumber#xpath=//*[text()='Mfr Number']";
	public static String Request_PrintItems_Quickcode = "Quickcode#xpath=//*[text()='Quick Code']";
	public static String Request_ClearCart = "ClearCart#xpath=//*[contains(text(),'Clear Cart')]";
	public static String Request_ClearCart_validation = "ClearValidation#xpath=//*[text()='Are you sure you want to clear all items?']";
	public static String Request_createNewServicePopUpText = "createNewServicePopUpText#xpath=//div[@class='modal-header']/div/span";
	public static String Request_cancelPopUP = "cancelPopUP#xpath=//*[@class='fa fa-2x fa-times']";
	public static String Request_ServiceLocationText="ServiceLocationText#xpath=//label[@for='shippingLocation']";
	public static String Request_ServiceDateText="ServiceDateText#xpath=//label[@for='txtExpectedDate']";
	public static String Request_CalenderIcon="CalenderIcon#xpath=//*[@class='input-group-btn']//button[@class='btn btn-default btn-sm']";
	public static String Request_CalenderDate="CalenderDate#xpath=//button[@id='datepicker-26501-1837-title']";
	public static String Request_VendorText="VendorText#xpath=//label[@for='vendor']";
	public static String Request_Description="Description#xpath=//*[@id='item_description']";
	public static String Request_sku="sku#xpath=//*[@id='sku']";
	public static String Request_purchasePrice="purchasePrice#xpath=//*[@name='purchasePrice']";
	public static String Request_saveButton="saveButton#xpath=name=//*[@ng-click='addItem()']";
	public static String Request_searchBox="searchBox#xpath=//input[@id='searchInput']";
	public static String Request_requestService="requestService#xpath=//button[@id='btnAdd']";
	public static String Request_Discountprice="DiscountPrice#xpath=//*[@ng-model='itemDetail.discounted_price']";
	//public static String Request_isServicePOToggle="isServicePOToggle#xpath=//div[@class='bootstrap-switch-small bootstrap-switch-id-isService bootstrap-switch bootstrap-switch-wrapper bootstrap-switch-animate bootstrap-switch-off']/div//span[@class='bootstrap-switch-handle-off bootstrap-switch-default']";
	public static String Request_isServicePOToggle="isServicePOToggle#xpath=//input[@id='isService']/../span[3]";
	public static String Request_getQty="getQty#xpath=(//*[@editable-text='service.newQty']//span)[1]";
	public static String Request_Delete="Delete#xpath=(//*[@class='fa fa-trash-o'])[2]";
	
	public static String Request_getItemName="getItemName#xpath=//div[@class='col-sm-18']/span/strong";
	public static String Request_getSkuName="getSkuName#xpath=//div[@class='col-sm-7']/span/small";
	public static String Request_vendorDropDown="vendorDropDown#xpath=//*[@id='vendor']";
	public static String Request_calenderIconAttribte="calenderIconAttribte#xpath=//button[@ng-click='open($event)']";
	public static String Request_Duration="Duration#xpath=//*[@ng-show='item.is_service==1']/select";
	public static String Request_Addbutton="AddButton#xpath=//*[@id='btnAdd' and contains(text(),'Add')]";
	public static String Request_validation="validation#xpath=//*[text()='Are you sure you want to delete this service item ?']";

	//ORDERS

	public static String Orders_Link="OrdersLink#xpath=//*[@href='#/orders']";
	public static String Order_PO_Doc_Icon ="PO_Doc_Btn#xpath=//i[@class='ng-scope fa fa-paperclip']";
	public static String Order_PO_Doc_HeaderTxt ="PO_Doc_HeaderTxt#xpath=//*[@class='headtext ng-binding']";
	public static String Order_PO_Doc_UploadFile ="PO_Doc_UploadFileTxt#xpath=//label[contains(text(),'Upload File')]";
	public static String Order_PO_Doc_CloseBtn ="PO_Doc_CloseBtn#xpath=//*[text()='Close']";
	public static String Order_PO_Doc_UploadFiles ="PO_Doc_UploadFile#xpath=//*[@type='file']";
	public static String Order_PO_Doc_Deletevalidation ="Deletevalidation#xpath=//*[text()='Are you sure, You want to remove this document ?']";

	public static String Order_PO_StatusDropdown_Cancelled ="Cancelled#xpath=//*[text()='Cancelled']";
	public static String Order_PO_StatusDropdown_On_Hold ="On_Hold#xpath=//*[text()='On-Hold']";
	public static String Order_PO_StatusDropdown_Changed ="Changed#xpath=//*[text()='Changed']";
	public static String Order_PO_StatusDropdown_Assigned ="Assigned#xpath=//*[text()='Assigned']";
	public static String Order_status_dropdown ="dropdown#xpath=//*[@id='status']";
	public static String Order_PO_StatusDropdown_Confirmed ="Confirmed#xpath=(//*[text()='Confirmed'])[1]";
	public static String Order_PO_SearchBtn ="SearchBtn#xpath=//button[text()='Search']";
	public static String Order_skuNUmber ="skuNUmber#xpath=//*[@class='table-responsive']//tbody//tr[@class='no-top-border']//td[@class='ng-binding']";
	public static String Order_PO_first_dropdown ="PO_first_dropdown#xpath=(//*[@class='fa fa-chevron-down'])[1]";
	public static String Order_PO_first_printPo ="PO_first_PrintPo#xpath=(//*[text()='Print PO'])[1]";
	public static String Order_PO_first_PoLog ="PO_first_PoLog#xpath=(//*[text()='PO Log'])[1]";
	//public static String Order_PO_PoLogHead ="PO_PoLogHead#xpath=(//*[@class='pagehead ng-binding'])[1]";
	public static String Order_PO_PoLogHead ="PO_PoLogHead#xpath=(//*[@class='textLayer']//div[1]";
	
	public static String Order_PO_headerText ="PO_PoLogHead#xpath=//*[@class='pagehead ng-binding']";
	public static String Order_PO_AuditLog ="PO_AuditLog#xpath=//*[@class='pagehead ng-binding']";
	public static String Order_PO_first_invoice ="PO_first_invoice#xpath=(//a[text()='Invoices'])[1]";
	public static String Order_PO_first_Addinvoice ="PO_first_Addinvoice#xpath=(//a[@ng-click='addInvoiceCall()'])[1]";
	public static String Order_PO_first_Addinvoice1 ="PO_first_Addinvoice#xpath=(//a[@ng-click='addInvoiceCall();'])[1]";
	public static String Order_PO_first_Allinvoice ="AllInvoice#xpath=(//*[text()='All Invoices'])[1]";
	public static String Order_InvoiceForText="InvoiceForText#xpath=(//*[@class='pagehead'])[1]";
	public static String Order_InvoiceCloseButton="InvoiceCloseButton#xpath=//*[@ng-click='back()']";
	public static String Order_PO_Invoice_Header ="Invoice_Header#xpath=//*[contains(text(),'Invoice for PO #:')]";
	public static String Order_PO_printPo_PDF ="PO_printPo_PDF#xpath=//*[@class='modal-header']//*[contains(text(),'Print PO')]";
	public static String Order_PO_first_AllInvoice ="PO_first_AllInvoice#xpath=(//*[text()='All Invoices'])[1]";
	public static String Order_PO_first_AllInvoice_Header ="PO_first_AllInvoice_Header#xpath=//*[@class='pagehead']";
	public static String Order_PO_Title ="PO_Title#xpath=//*[@ng-click=\"order('PONUM')\"]";
	public static String Order_PO_idList ="PO_Idlist#xpath=(//*[@ng-repeat='order in ordersData.purchaseOrders']/td/a)";

	public static String Assending ="Assending#xpath=//*[@class='fa fa-caret-up']";
	public static String Descending ="Descending#xpath=//*[@class='fa fa-caret-down']";
	public static String conditionForNoOrder ="conditionForNoOrder#xpath=//div[@class='panel-body']/tbody/tr/td";
	public static String NOOrderFound ="NOOrderFound#xpath=//*[@class='table']/tbody/tr[1]/td[1]";
	public static String Order_PO_StatusDropdown_PartialReceived ="PartialReceived#xpath=//*[text()='Partial Received']";
	public static String Order_PO_StatusDropdown_Completed ="Completed#xpath=//*[text()='Completed']";
	public static String Order_FacilityDropDown ="FacilityDropDown#xpath=//*[@id='facility']";



	//INVOICE 

	public static String Request_InvoicePageLink="InvoicePageLink#xpath=//*[@href='#/invoice']";
	public static String Invoice_InvoiceDesc="InvoiceDesc#xpath=//input[@id='txtInvNo']";
	public static String Invoice_wait="wait#xpath=//*[@id='ng-view']";
	public static String Invoice_InvoicePONum="Invoice_InvoicePONum#xpath=//div[@class='pagehead']/span";
	public static String Invoice_AddItemInInvoice="AddItemInInvoice#xpath=//select[@name='POItems']";
	public static String Invoice_AddItemButton="AddItemButton#xpath=//button[@ng-click='AddItemToInvoice()']";
	public static String Invoice_POLabel="POLabel#xpath=//*[@for='POItems']";
	public static String Invoice_ItemQtyField="ItemQtyField#xpath=//input[id='ItemQty']";
	public static String Invoice_SaveButton="SaveButton#xpath=//button[@ng-click='saveInvoice()']";
	public static String Invoice_ConfirmButton="ConfirmButton#xpath=//button[@class='confirm']";
	public static String Invoice_DocPopUPText="DocPopUPText#xpath=//div[@class='modal-header']/div[@class='headtext ng-binding']";
	public static String Invoice_DocButton="DocButton#xpath=//button[@ng-click='attachFiles()']";
	public static String Invoice_UploadButton="UploadButton#xpath=//*[@id='pic']../label";
	public static String Invoice_UploadDocName="UploadDocName#xpath=(//*[@ng-repeat='item in rows']//a)[2]";
	//public static String Invoice_closeButton="closeButton#xpath=//button[text()='cancel()']";
	public static String Invoice_closeButton="closeButton#xpath=//*[@class='fa fa-2x fa-times']";
	public static String Invoice_SearchInInvoiceTextBox="SearchInInvoiceTextBox#xpath=//*[@id='search']";
	public static String Invoice_SearchButton="SearchButton#xpath=//button[@type='submit']";
	public static String Invoice_SelectPending="SelectPending#xpath=//div[@class='input-sm ui-select-container ui-select-bootstrap dropdown ng-not-empty ng-valid ng-touched ng-dirty ng-valid-parse']";
	public static String Invoice_SelectFirstInvoice="SelectFirstInvoice#xpath=//*[@class='table']/tbody/tr[1]/td[1]/a";
	public static String Invoice_SelectFirstPO="SelectFirstPO#xpath=//*[@class='table']/tbody/tr[1]/td[2]";
	public static String Invoice_SelectAllUserDropDown="SelectAllUserDropDown#xpath=//input[@type='search']";
	public static String Invoice_SelectAllUser="SelectAllUser#xpath=//*[text()='All']";
	public static String Invoice_PageHeadText="PageHeadText#xpath=//div[@class='pagehead']";
	public static String Invoice_PageHeadTextIncludingPONum="PageHeadTextIncludingPONum#xpath=//div[@class='pagehead']/span";
	public static String Invoice_clickOnUploadFIle="clickOnUploadFIle#xpath=//*[@type='file']";
	public static String Invoice_PONUmInHeader="clickOnUploadFIle#xpath=//*[@class='pagehead']/span";
	public static String Invoice_SelectFirstPONUmFromInvoicePage="SelectFirstPONUmFromInvoicePage#xpath=//*[@class='table']/tbody/tr[1]/td[2]";
	public static String Invoice_SelectFirstInvoiceFromInvoicePage="SelectFirstInvoiceFromInvoicePage#xpath=//*[@class='table']/tbody/tr[1]/td[1]/a";
	public static String Invoice_DownoadPDF="Invoice_DownoadPDF#xpath=(//*[@class='fa fa-download'])[1]";
	public static String Invoice_PrintPDF="PrintPDF#xpath=(//*[@ng-click='openPDF()'])[1]";
	public static String Invoice_PrintPReviewWindow="PrintPReviewWindow#xpath=//*[contains(text(),'Print Invoice')]";
	public static String Invoice_PrintPReviewclose="PrintPReviewclose#xpath=//*[@class='fa fa-times']";
	public static String Invoice_vendorDropDownLabels="vendorDropDownLabels#xpath=//*[text()='Vendor:']";
	public static String Invoice_vendorDropDowns="vendorDropDown#xpath=//*[@name='vendor_name']";
	public static String Invoice_statusDropDowns="statusDropDown#xpath=//*[@name='status']";
	public static String Invoice_statusDropDownLabel="statusDropDownLabel#xpath=//label[@for='ddlStatus']";
	public static String Invoice_SearchBYDueDateDropDowns="statusDropDown#xpath=//*[@name='dateRange']";
	public static String Invoice_SearchBYDueDateLabel="statusDropDownLabel#xpath=//*[text()='Search by Due-Date']";

	public static String Invoice_FacilityLabel="facilityLabel#xpath=//*[text()='Facility']";
	public static String Invoice_facilityDateDropDowns="facilityDateDropDowns#xpath=//*[@name='facility']";
	public static String Invoice_departmentLabel="departmentLabel#xpath=//label[@for='depts']";
	public static String Invoice_departmentDropDown="departmentDropDown#xpath=//*[@name='depts']";
	public static String Invoice_OrderedByLabel="OrderedByLabel#xpath=//*[text()='Ordered By:']";
	public static String Invoice_OrderedByDropDown="OrderedByDropDown#xpath=//*[@name='ddlOrderby']";
	public static String Invoice_SentToAccounting="SentToAccounting#xpath=//button[contains(text()='SentToAccounting')]";
	public static String Invoice_firstInvoice="first#xpath=//*[@class='table']//tr[1]/td[1]/a";
	public static String Invoice_Delete="Delete#xpath=(//i[@class='glyphicon glyphicon-trash text-danger action-button'])[1]";
	public static String Invoice_confirmButton="Invoice_confirmButton#xpath=//button[@class='confirm']";
	public static String Invoice_NoInvoiceFoundMessage="NoInvoiceFoundMessage#xpath=//*[text()='No Invoice Found']";
	public static String Invoice_Download ="Download#xpath=(//*[@tooltip='Download pdf'])[1]";
	public static String Invoice_selectedUserInDropDown="selectedUserInDropDown#xpath=//div[@name='ddlOrderby']/span/span[2]/span";
	//SHIPMENTS
	public static String Shipment_PageLink="PageLink#xpath=//*[@href='#/orders/shipments']";
	public static String Shipment_FirstShipmentNum="FirstShipmentNum#xpath=//*[@class='table table-striped']//tbody//tr[1]//td[1]/a[1]";
	public static String Shipment_ShipmentPONum="ShipmentPONum#xpath=//*[@class='table table-striped']//tbody/tr[1]/td[2]";
	public static String Shipment_TrackingNum="TrackingNum#xpath=//*[@class='table table-striped']//tbody/tr[1]//td/span";
	public static String Shipment_wait="wait#xpath=//*[@id='ng-view']";
	public static String Shipment_SearchTextBox="SearchTextBox#xpath=//*[@id='shipment-search']";
	public static String Shipment_SubmitButton="SubmitButton#xpath=//button[text()='Search']";
	//public static String Shipment_ShipmentDetailPAge="ShipmentDetailPage#xpath=//*[contains(text(),'Shipment#')]";
	public static String Shipment_ShipmentDetailPAge="ShipmentDetailPAge#xpath=//*[@class='pagehead ng-binding']";
	public static String Shipment_StatusDropDown="StatusDropDown#xpath=//*[@id='sel1']";

	public static String Shipment_ReceiveButtonText="ReceiveButtonText#xpath=//div[@class='pull-right']/button[3]";
	public static String Shipment_CloseButton="CloseButton#xpath=//div[@class='pull-right']/button[4]";

	//ORGSettings page

	public static String orgsetting_crosswalk="crosswalk#xpath=//*[@id='use_cross_walk_as_item_identifier']";
	public static String orgsetting_crosswalktext="crosswalktext#xpath=//input[@id='cross_walk_desc']";
	public static String orgsetting_IntactSetting="IntactSetting#xpath=//input[@id='intacct_integration']";
	public static String orgsetting_QuickBookIntegrationSetting="QuickBookIntegrationSetting#xpath=//input[@id='quick_book_integration']";		
	public static String orgsetting_AdminMenuText="AdminMenuText#xpath=//admin-menu//li[text()='Admin']";			
	public static String orgsetting_orgPageTextt="orgPageTextt#xpath=//div[@class='pagehead']";		
	public static String orgsetting_orgFeaturesPageText="orgFeaturesPage#xpath=//*[@class='sub-header-block' and text()='Inventory']";
	public static String orgsetting_orgBudgetPage="orgBudgetPage#xpath=//a[@href='#/admin/organization-budget']";
	public static String orgsetting_orgBudgetPageText="orgBudgetPageText#xpath=//div[@class='pagehead']";

	//Users Page
	public static String Users_page="Users_page#xpath=//*[@href='#/admin/users']";
	public static String Users_SearchByText="SearchByText#xpath=//*[@for='search-search']";
	public static String Users_SearchTextBox="SearchTextBox#xpath=//*[@class='form-group']//*[@id='search-search']";
	public static String Users_FacilityText="FacilityText#xpath=//*[@for='search-facility']";
	public static String Users_FacilityDropDown="FacilityDropDown#xpath=//*[@id='search-facility']";
	public static String Users_StatusText="Status#xpath=//*[@for='search-status']";
	public static String Users_StatusDropDown="StatusDropDown#xpath=//*[@id='search-status']";
	public static String Users_SearchButton="SearchButton#xpath=//button[@type='submit']";
	public static String Users_FirstUserName="FirstUserName#xpath=//*[@id='isotopeContainer']//*[@class='user-detail-container']//*[@class='ng-binding'][1]";
	public static String Users_FirstUserEmail="FirstUserEmail#xpath=//*[@id='isotopeContainer']//*[@class='user-detail-container']//*[@class='ng-binding'][3]";
	public static String Users_EditFirstUser="EditFirstUser#xpath=(//*[@ng-click='editUser(adminUserData.id)'])[1]";
	public static String Users_EditUserTextPopUp="EditUserTextPopUp#xpath=//*[contains,(text(), 'Edit User')]";
	public static String Users_NameEditBox="NameEditBox#xpath=//*[@id='name']";
	public static String Users_EmployeeEditBox="NameEditBox#xpath=//*[@id='employee_no']";
	public static String Users_NickNameEditBox="NickNameEditBox#xpath=//*[@id='nickname']";
	public static String Users_EmailEditBox="EmailEditBox#xpath=//*[@id='email']";
	public static String Users_PasswordEditBox="PasswordEditBox#xpath=//*[@id='password']";
	public static String Users_ConfirmPasswordEditBox="ConfirmPasswordEditBox#xpath=//*[@id='con_password']";
	public static String Users_ClosePopup="ClosePopup#xpath=//i[@class='fa fa-2x fa-times']";
	public static String Users_AddNewUser="AddNewUser#xpath=//button[@ng-click='createUser()']";
	public static String Users_AddUserPopupText="AddUserPopupText#xpath=//*[@class='modal-content']//span[2]";
	public static String Users_AddUserPopupClose="AddUserPopupClose#xpath=//*[@class='fa fa-2x fa-times']";
	public static String Users_EditUserButton="EditUserButton#xpath=//button[@ng-click='editUser(adminUserData.id)']";
	//public static String Users_EditUserButton="EditUserButton#xpath=//button[text()='Edit']";
	public static String Users_EditUserPopupText="EditUserPopupText#xpath=//*[@class='modal-content']//span[1]";
	public static String Users_ChangePasswordButton="ChangePasswordButton#xpath=(//button[@ng-click='changePassword(adminUserData.id)'])[1]";
	public static String Users_ChangePasswordPopUpText="ChangePasswordPopUpText#xpath=//*[@class='headtext']";
	public static String Users_SaveButton="SaveButton#xpath=//*[@class='modal-footer']//button[@ng-click='saveUserFn(user)']";
	public static String Users_FacilityDropDownAddUSer="FacilityDropDownAddUSer#xpath=//*[@id='facility']";
	public static String Users_DepartmentDropDownAddUSer="FacilityDropDownAddUSer#xpath=//*[@id='department']";
	public static String Users_WaitDepartmentDropDownAddUSer="WaitFacilityDropDownAddUSer#xpath=//*[@id='department']/option";
	public static String Users_InventoryDropDownAddUSer="InventoryDropDownAddUSer#xpath=//*[@id='inventory']";
	public static String Users_WaitInventoryDropDownAddUSer="WaitInventoryDropDownAddUSer#xpath=//*[@id='inventory']";
	public static String Users_vendorAccessTab="vendorAccessTab#xpath=//li[@header='Vendor Access']/a";
	public static String Users_vendorAccessTab1="vendorAccessTab#xpath=//*[text()='Vendor Access']";
	public static String Users_SelectVendorsDropDown="SelectVendorsDropDown#xpath=//*[@for='itemslist']//i[@class='fa fa-ellipsis-v autocomplete-show'";
	public static String Users_SelectAllVendors="SelectAllVendors#xpath=//button[contains(text(), 'Select all') and contains(@ng-click='selectAllItems()')]";
	public static String Users_waitforResult="waitforResult#xpath=//*[@class='grid-item ng-scope']";
	public static String Users_facilityTab="facilityTab#xpath=//*[text()='Facility Access']";

	public static String Users_searchTextBoxFacTab="searchTextBoxFacTab#xpath=//*[@id='searchFacility']";
	public static String Users_AllPermissionsCheckBox="AllPermissionsCheckBox#xpath=//*[@id='facility_checkbox_5']";
	public static String Users_saveButton="saveButton#xpath=//*[@ng-click='saveUserFn(user)']";
	//Facilities

	public static String Facilty_FacilityLink="FacilityLink#xpath=//*[@href='#/admin/facility']";	
	public static String Facilty_WaitforTableElem="WaitforTableElem#xpath=//*[@id='reqListing']";
	public static String Facilty_firstFacility="firstFacility#xpath=//*[@id='reqListing']//td[@class='ng-binding'][1]";
	public static String Facilty_SearchBox="SearchBox#xpath=//*[@id='search-search']";
	public static String Facilty_SearchButton="SearchButton#xpath=//button[@type='submit']";
	public static String Facilty_AddFacilityButton="AddFacilityButton#xpath=//button[@ng-click='createFacility()']";
	public static String Facilty_AddFacilityText="AddFacilityText#xpath=//*[@class='modal-header']//span[2]";
	public static String Facilty_EditFacility="EditFacility#xpath=(//i[@class='fa fa-edit'])[1]";
	public static String Facilty_EditFacilityText="AddFacilityText#xpath=//*[@class='modal-header']//span[1]";
	public static String Facilty_DepartmentNames="DepartmentNames#xpath=//ul[@class='facility_department_sublist'][1]//li";
	public static String Facilty_firstdrillDown="firstdrillDown#xpath=(//button[@class='btn btn-sm btn-default rounded-button ng-scope'])[1]";
	public static String Facility_wait="wait#xpath=//*[@id='reqListing']";

	//Department

	public static String Dep_PageLink="PageLink#xpath=//*[@href='#/admin/department']";
	public static String Dep_SelectFac="Dep_SelectFac#xpath=//*[@name='facility']";
	public static String Dep_SearchButton="SearchButton#xpath=//button[@type='submit']";
	public static String Dep_SearchTextBox="SearchTextBox#xpath=//*[@id='search-search']";
	public static String Dep_allDeps="allDeps#xpath=//*[@class='grid-item ng-scope']";
	public static String Dep_firstDeps="firstDeps#xpath=(//*[@class='grid-item ng-scope']//*[@class='grid-heading grid-title-label ng-binding'])[1]";
	public static String Dep_wait="wait#xpath=//*[@id='isotopeContainer-']";
	public static String Dep_addNewDep="addNewDep#xpath=//*[@class='pagehead']//button[text()='Add']";
	public static String Dep_addFacName="addFacName#xpath=//*[@id='facility']";
	public static String Dep_addFacmnemonic="addmnemonic#xpath=//*[@id='mnemonic']";
	public static String Dep_addName="addDepName#xpath=//*[@id='name']";
	public static String Dep_saveButton="saveButton#xpath=//*[@class='modal-footer']//button[text()='Save']";
	public static String Dep_editButton="editButton#xpath=//*[@class='grid-row-value']//button[text()='Edit']";
	public static String Dep_DeleteButton="DeleteButton#xpath=//*[@class='grid-row-value']//button[text()='Delete']";
	public static String Dep_confirmButton="confirmButton#xpath=//*[@class='confirm']";
	public static String Dep_EditFirst="Editdept#xpath=(//*[@ng-click='editDepartment(adminDepartmentData.id)'])[1]";
	public static String Dep_Edit_title="Edittitle#xpath=//*[contains(text(),'Edit Department')]";
	public static String Dep_Delete_First="Deletedept#xpath=(//button[text()='Delete'])[1]";
	public static String Dep_Delete_validation="Delete_validation#xpath=//*[text()='Are you sure you want to delete this department ?']";
	public static String Dep_Delete_Cancel="Delete_Cancel#xpath=//button[text()='Cancel']";
	public static String Dep_Delete_Yes="Delete_Yes#xpath=//button[text()='Yes']";
	public static String Dep_Edit_Close="Close#xpath=//*[@class='modal-header']//button[@class='close']";
	
	//Physician
	public static String Phy_pageLink="pageLink#xpath=//*[@href='#/preference-card/physicians']";
	public static String Phy_SelectFac="Phy_SelectFac#xpath=//*[@id='facility']";
	public static String Phy_SearchButton="SearchButton#xpath=//button[@type='submit']";
	public static String Phy_waitfortable="waitforTable#xpath=//*[@class='table table-striped']";
	public static String Phy_addNewPhy="addNewPhy#xpath=//*[@class='pagehead']//button[text()='Add Physician']";
	public static String Phy_addfirstName="Phy_addfirstName#xpath=//*[@id='first_name']";
	public static String Phy_addlastName="Phy_addlastName#xpath=//*[@id='last_name']";
	public static String Phy_addnpi="Phy_addnpi#xpath=//*[@id='mrn_number']";
	public static String Phy_facDropDown="Phy_facDropDown#xpath=//*[@for='itemslist']";
	public static String Phy_typeDefault_Fac="Phy_typeDefault_Fac#xpath=//*[@id='itemslist']";
	public static String Phy_selectDef_Fac="Py_selectDef_Fac#xpath=//*[@id='itemslist']//li[1]//*[@class='vendor-lit-container autocomplete-show']";
	public static String Phy_plusIcon="plusIcon#xpath=(//*[@ng-click='selectItem(item.name,item.id)'])[1]";
	public static String Phy_saveButton="saveButton#xpath=//*[@class='modal-footer']//button[text()='Save']";
	public static String Phy_SearchTextBox="SearchTextBox#xpath=//*[@id='search']";
	public static String Phy_firstFacInDropDown="firstFacInDropDown#xpath=//ul[@class='vendor-list autocomplete-show']//li[1]";
	public static String Phy_firstFacAfterSearch="firstFacAfterSearch#xpath=//*[@class='table table-striped']//tr/td[1]";
	public static String Phy_firstNPIAfterSearch="firstNPIAfterSearch#xpath=//*[@class='table table-striped']//tr/td[2]";
	public static String Phy_wait="wait#xpath=//*[@id='ng-view']";
	public static String Phy_wait_onEdit="onEdit#xpath=(//*[@class='fa fa-edit'])[1]";
	public static String Phy_editButton="editButton#xpath=(//*[@class='fa fa-edit'])[1]";
	public static String Phy_deleteButton="deleteButton#xpath=(//*[@class='fa fa-trash-o'])[1]";
	public static String Phy_confirmButton="confirmButton#xpath=//*[@class='confirm']";
	//Receive Module	
	public static String Receive_statusDropdownOptions="statusDropdownOptions#xpath=//*[@id='status']/ul/li//span[@class='ui-select-choices-row-inner']/span";
	public static String Receive_pageLink="pageLink#xpath=//*[@href='#/orders/receive']";
	public static String Receive_wait="wait#xpath=//*[@class='table']/thead/tr";
	public static String Receive_statusDropdown="statusDropdown#xpath=//*[@id='status']";
	public static String Receive_vendorDropdown="vendorDropdown#xpath=//*[@id='vendor']";
	public static String Receive_typeDropdown="typeDropdown#xpath=//*[@id='type']";
	public static String Receive_facilityDropdown="typeDropdown#xpath=//*[@id='facility']";

	public static String Receive_UsersDropdown="UsersDropdown#xpath=//*[@name='creater']";
	
	public static String Invoice_UsersDropdown="UsersDropdown#xpath=//div[@name='ddlOrderby']";
	public static String Receive_departmentDropdown="typeDropdown#xpath=//*[@id='depts']";
	public static String Receive_createdByDropdown="typeDropdown#xpath=//*[@id='creater']";
	public static String Receive_NotesLinkWait="NotesLinkWait#xpath=//*[@class='table']";
	public static String Receive_DocLinkWait="NotesLinkWait#xpath=//*[@class='table']";
	public static String Receive_NotesLink="NotesLink#xpath=(//a[@ng-click='openPONote(order)'])[1]";

	public static String Receive_NotesLinkPODetail="NotesLinkPODetail#xpath=//i[@class='ng-scope fa fa-sticky-note-o']";
	public static String Receive_NotesLinkText="NotesLinkText#xpath=(//*[@class='modal-header']//span[@class='ng-binding'])[1]";
	public static String Receive_AddNewNotesLink="AddNewNotesLink#xpath=//button[@ng-click='createNewNoteFn();']";
	public static String Receive_DocsLink="DocsLink#xpath=(//*[@class='pull-right dropdown']/a[@ng-click='attachFiles(order)'])[1]";
	public static String Receive_DocsLinkPODetail="DocsLinkPODetail#xpath=(//*[@class='ng-scope fa fa-paperclip'])[1]";
	public static String Receive_DocsLinkText="DocsLinkText#xpath=(//*[@class='headtext ng-binding'])[1]";
	public static String Receive_DrillDownIcon="DrillDownIcon#xpath=(//*[@ng-click='getInvoiceData(order)'])[1]";
	public static String Receive_DrillDownIconwait="DrillDownIconwait#xpath=//*[@class='table']";
	public static String Receive_DrillDownPODetailPage="DrillDownPODetailPage#xpath=//button[@type='button' and @ng-click='getInvoiceData(orderData.order);']";
	public static String Receive_PrintPOLink="PrintPOLink#xpath=(//*[@class='dropdown-menu']//*[@ng-click='openPDF()'])[1]";
	public static String Receive_PrintPOLinkPoDetail="PrintPOLinkPoDetail#xpath=//*[@ng-click='openPDF()']";
	public static String Receive_PrintPOText="PrintPOText#xpath=(//*[@class='modal-header']//*[@class='ng-binding'])[1]";
	public static String Receive_PrintPReviewclose="PrintPReviewclose#xpath=//*[@class='fa fa-times']";
	public static String Receive_PrintCloseclose="PrintPReviewclose#xpath=//*[@class='fa fa-2x fa-times']";
	public static String Receive_InvoiceForText="InvoiceForText#xpath=(//*[@class='pagehead'])[1]";
	public static String Receive_PrintPODetailPage="PrintPODetailPage#xpath=[@class='modal-header']/span";
	public static String Receive_AllInvoiceLink="AllInvoiceLink#xpath=(//a[text()='All Invoices'])[1]";
	//public static String Receive_firstPONum="firstPONum#xpath=(//*[@class='table']//a[@class='ng-binding'])[1]";
	public static String Receive_firstPONum="firstPONum#xpath=//*[@class='table']//tr/td[1]/a[1]";
	public static String Receive_PrintItems="PrintItems#xpath=(//*[@ng-click='downloadPdf(order)']";
	public static String Receive_PrintitemsText="PrintitemsText#xpath=(*//[@class='headtext']/span[1])";
	public static String Receive_firstPOHeadingText="firstPOHeadingText#xpath=//*[@class='col-sm-18']/*[@class='pagehead ng-binding' and contains(text(),'Purchase Order #')]";
	public static String Receive_itemNames="itemNames#xpath=//table[@class='table table-body-striped ng-scope']//item-info[@class='ng-isolate-scope']";
	public static String Receive_PODetailDrillDown="PODetailDrillDown#xpath=//button[@type='button' and @ng-click='getInvoiceData(orderData.order);']";
	public static String Receive_AdditemsToCart="AdditemsToCart#xpath=//li[@ng-if='allowAddToCart(order)']/a[@ng-click='AddOrderItemsTOCart(order);']";
	public static String Receive_searchButton="searchButton#xpath=//button[@type='submit']";
	public static String Receive_itemsNamesInCart="itemsNamesInCart#xpath=(//*[@value='name'])[1]";

	public static String Receive_AddNewNote="AddNewNote#xpath=//*[@class='form-group']/textarea";
	public static String Receive_AddNewNoteButton="AddNewNoteButton#xpath=//button[@ng-click='add()']";
	public static String Receive_searchBox="searchBox#xpath=//input[@type='text']";
	public static String Receive_searchedfirstNote="searchedfirstNote#xpath=(//*[@class='sorting_1 poNote ng-binding'])[1]";
	public static String Receive_DeleteIcon="DeleteIcon#xpath=(//i[@class='fa fa-trash'])[1]";

	//public static String Receive_NotesDeleteIcon="NotesDeleteIcon#xpath=(//*[@ng-click='deleteNoteFn(note.id, $index)']/i)[1]";
	public static String Receive_NotesDeleteIcon="NotesDeleteIcon#xpath=//i[@class='notes-list ng-scope']//span[@class='pull-right ng-scope']//a[2]/i";	
	public static String Receive_confirmButton="confirmButton#xpath=//button[@class='confirm']";
	//public static String Receive_NoNOteavailable="NoNOteavailable#xpath=//*[@class='row']//h4[1]";
	public static String Receive_NoNOteavailable="NoNOteavailable#xpath=//h4[text()='No note available.']";



	public static String Receive_POLOg="POLOg#xpath=//*[@ng-click='openPOLog(order)']";
	public static String Receive_POLOgText="POLOgText#xpath=//*[@class='pagehead ng-binding']";
	public static String Receive_printPO="printPO#xpath=//a[@ng-click='downloadPdf(order);']";	
	public static String Receive_printItemsDetailPage="printItemsDetailPage#xpath=//a[text()='Print Items']";
	public static String Receive_printPOText="printPOText#xpath=//*[@class='headtext']/span";
	public static String Receive_uploadFile="uploadFile#xpath=//*[@type='file']";
	public static String Receive_PODetailAddInvoice ="PODetailAddInvoice#xpath=//i[@class='fa fa-plus']";
	public static String Receive_PODetailInvoiceText ="PODetailInvoiceText#xpath=//*[@class='pagehead']";
	public static String Receive_AllInvoiceDetailPage ="AllInvoiceDetailPage#xpath=//*[text()='All Invoices']";
	public static String Receive_POLogDetailPage ="POLogDetailPage#xpath=//*[text()='PO Log']";
	public static String Receive_AddOrderItemsTOCartDetaipPage="AddOrderItemsTOCartDetaipPage#xpath=//a[@ng-click='AddOrderItemsTOCart();']";
	public static String Receive_SearchTextBox="SearchTextBox#xpath=//*[@id='PONUM']";
	public static String Receive_POApprovalLogs="POApprovalLogs#xpath=//*[text()='PO Approval Log']";
	public static String Receive_POApprovalLogsPopUpText="POApprovalLogsPopUpText#xpath=//*[contains(text(),' PO Approval Logs for PO #')]";
	public static String Receive_PODetailNotesLinkDrillDown="PODetailNotesLinkDrillDown#xpath=//*[text()='Notes']";
	public static String Receive_PODocsDrillDown="POApprovalLogs#xpath=//*[text()='Documents']";	 
	public static String Receive_UploadDocNameDetailPage="UploadDocName#xpath=(//a[@class='ng-binding'])[2]";
	public static String Receive_waitDoc="waitDoc#xpath=ng-click=//*[@ng-repeat='item in rows'])";
	public static String Receive_ReceiveOnlyText="ReceiveOnlyText#xpath=//*[text()='Mark as Receive Only']";
	public static String Receive_ShowTour="ShowTour#xpath=//*[text()='Show Tour']";
	public static String Receive_NextButton="NextButton#xpath=//button[@class='btn btn-sm btn-default ng-scope' and text='Next ï¿½']";
	public static String Receive_EndButton="EndButton#xpath=//button[@class='btn btn-sm btn-primary' and text='End tour']";
	public static String Receive_patialButtonText="patialButtonText#xpath=(//button[@id='btnAdd'])[4]//span";
	public static String Receive_completeButtonText="completeButton#xpath=(//button[@id='btnAdd'])[5]//span";
	public static String Receive_CloseButtonText="closeButton#xpath=(//button[@id='btnAdd'])[10]";
	public static String Receive_Depatment="Depatment#xpath=(//*[@ng-if='!orderData.is_po_editable || !canModify']/strong)[1]";
	public static String Receive_Physician="Physician#xpath=(//*[@ng-if='!orderData.is_po_editable || !canModify']/strong)[2]";
	public static String Receive_OrdersListingPageText="OrdersListingPageText#xpath=//*[@class='col-sm-18']//*[@class='pagehead ng-binding']";
	public static String Receive_ShowTourText="ShowTourText#xpath=//button[text()='End tour']";
	public static String Receive_selectedFacInDropDown="selectedFacInDropDown#xpath=//*[@id='facility']//span[1]";
	public static String Receive_selectedUserInDropDown="selectedUserInDropDown#xpath=//*[@id='creater']//span[@class='ui-select-match-text pull-left']/span";
	
	// Receive Order Details
	public static String ReceiveOrderDetails_Close="Close#xpath=.//*[@id='btnAdd' and contains(text(),'Close')]";
	public static String ReceiveOrderDetails_receivedAmount="receivedAmount#xpath=//*[@id='receivedAmount";
	public static String ReceiveOrderDetails_PartialReceive="PartialReceive#xpath=//*[@id='btnAdd' and contains(text(),'Partial Receive')]";
	public static String ReceiveOrderDetails_Itemfirst="Itemfirst#xpath=(//input[@ng-change='checkFn(poItem)'])[1]";
	public static String ReceiveOrderDetails_validation="validation#xpath=//*[text()='Are you sure, you want to mark this purchase order as partial received ?']";
	public static String ReceiveOrderDetails_Complete="Complete#xpath=//*[@id='btnAdd' and contains(text(),'Complete')]";
	public static String ReceiveOrderDetails_Line="Line#xpath=//*[text()='Line #']";
	public static String ReceiveOrderDetails_itemGLCode="itemGLCode#xpath=//*[text()='Item/GL Code']";
	public static String ReceiveOrderDetails_NOItem="NoItem#xpath=//*[text()='No item added in invoice.']";
	public static String ReceiveOrderDetails_InvoiceBlank="InvoiceBlank#xpath=//*[text()='Invoice # is blank.']";
	public static String ReceiveOrderDetails_AttachHardCopy="AttachHardCopy#xpath=//*[@uib-tooltip='View & Attach Hard Copy']";
	public static String ReceiveOrderDetails_AttachHardCopy_InvoiceHardCopy="InvoiceHardCopy#xpath=//*[text()='Invoice Hard Copies']";
	
	//OPERATING ROOM

	public static String OP_ORoomPageLink="CreateORoomPageLink#xpath=//a[@href='#/preference-card/operating-rooms']";
	public static String OP_wait="wait#xpath=//*[@class='table table-striped']/thead/tr";
	public static String OP_wait2="wait#xpath=//*[@id='ng-view']";
	
	public static String OP_CreatenewOP="CreatenewOP#xpath=//button[@class='btn btn-primary pull-right']";
	public static String OP_OpName="OpName#xpath=//*[@id='name']";
	public static String OP_CreatenewOPText="CreatenewOPText#xpath=//*[@class='headtext']/span";
	public static String OP_FacilityInput="Facilty#xpath=(//*[@id='facility']/input)[1]";
	public static String OP_FacilityDropDown="FacilityDropDown#xpath=//*[@id='facility']";
	public static String OP_disabledSaveButton="disabledSaveButton#xpath=//*[@class='modal-footer']/button[1]";
	public static String OP_editheader="Editheader#xpath=//*[contains(text(),'Edit Operating Room')]";
	public static String OP_enabledSaveButton="enabledSaveButton#xpath=//*[@class='modal-footer']/button[@disabled='disabled']";
	public static String OP_searchTextBox="searchTextBox#xpath=//input[@id='search']";
	public static String OP_Name="Name#xpath=//table//*[contains(text(),'Name')]";
	public static String OP_Facility="Facility#xpath=//th[contains(text(),'Facility')]";
	public static String OP_created_at="created_at#xpath=//*[@ng-click=\"order('created_at')\"]";
	public static String OP_searchButton="searchButton#xpath=//button[@type='submit']";
	public static String OP_firstOPRoom="firstOPRoom#xpath=//*[@class='table table-striped']//tr/td";
	public static String OP_EditButton="EditButton#xpath=//*[@class='pull-right']//i[1]";
	public static String OP_DeleteButton="DeleteButton#xpath=//*[@class='pull-right']//i[@class='fa fa-trash-o']";
	public static String OP_confirmButton="confirmButton#xpath=//button[@class='confirm']";


	//Patients

	public static String Patient_PatientsPageLink="PatientsPageLink#xpath=//a[@href='#/preference-card/patients']"; 
	public static String Patient_wait="wait#xpath=//*[@id='ng-view']";
	public static String Patient_getfacilityName = "getfacilityName#xpath=//*[@ng-click='selectItem();']";
	public static String Patient_ShopfaclitySelect = "ShopfaclitySelect#xpath=//*[@title='Select Facility']";
	public static String Patient_Shopfaclity = "Shopfaclity#xpath=//*[text()='Select Facility']";
	public static String Patient_plusIcon = "plusIcon#xpath=(//button[@class='btn btn-sm btn-default ng-scope'])[1]";
	public static String Patient_firstPatient="firstPatient#xpath=//*[@class='table table-striped']//tbody/tr[1]/td[1]";
	//public static String Patient_firstPatient="firstPatient#xpath=(//tbody//*[@ng-repeat-start='patient in patients'])[1]";
	public static String Patient_firstPatientwait="firstPatient#xpath=//*[@class='table table-striped']//tbody";
	public static String Patient_EditPAtient="EditPAtient#xpath=(//*[@class='fa fa-edit'])[1]";
	public static String Patient_PrintIcon="PrintIcon#xpath=(//*[@class='fa fa-print'])[1]";
	public static String Patient_EditPAtientPopUp="EditPAtientPopUp#xpath=//*[@class='headtext']/span";
	public static String Patient_MovePatient="MovePAtient#xpath=(//*[@uib-tooltip='Move patient from current facility'])[1]";
	public static String Patient_EditPAtientPopUpCancel="EditPAtientPopUpCancels#xpath=//*[@class='fa fa-2x fa-times']";
	public static String Patient_ClosePreview="ClosePreview#xpath=//*[@class='fa fa-times']";
	public static String Patient_previewpopup="previewpopup#xpath=//*[@class='modal-header']";
	public static String Patient_AddPatient="AddPatient#xpath=//button[@class='btn btn-primary pull-right ng-scope']";
	public static String Patient_SaveButton="SaveButton#xpath=//*[@class='modal-footer']";
	public static String Patient_firstName="firstName#xpath=//*[@id='first_name']";
	public static String Patient_middleName="middleName#xpath=//*[@id='middle_name']";
	public static String Patient_lastName="lastName#xpath=//*[@id='last_name']";
	public static String Patient_FacilitySelect="FacilitySelect#xpath=//hyb-select/a";
	public static String Patient_mrnNumber="mrnNumber#xpath=//*[@id='mrn_number']";
	public static String Patient_accNumber="accNumber#xpath=//*[@id='account_number']";
	public static String Patient_dob="dob#xpath=//*[@id='dob']";
	public static String Patient_facDropDown="facDropDown#xpath=//*[@id='facility']";
	public static String Patient_firstFac="firstFac#xpath=//li[@class='ui-select-choices-group']//span[@class='ng-binding ng-scope'][1]";
	public static String Patient_disabledSaveButton="disabledSaveButton#xpath=//*[@class='modal-footer']/button[@class='btn btn-primary']";
	public static String Patient_enabledSaveButton="enabledSaveButton#xpath=//*[@class='modal-footer']/button[@disabled='disabled']";
	public static String Patient_searchTextBox="searchTextBox#xpath=//*[@id='search']";
	public static String Patient_searchbutton="searchbutton#xpath=//button[@type='submit']";
	public static String Patient_add01="add01#xpath=//*[@id='address1']"; 
	public static String Patient_add02="add02#xpath=//*[@id='address2']";
	public static String Patient_city="city#xpath=//*[@id='city']";
	public static String Patient_state="state#xpath=//*[@id='state']";
	public static String Patient_zip="zip#xpath=//*[@id='zip']";
	public static String Patient_Phone="Phone#xpath=//*[@id='primary_phone']";
	public static String Patient_secphone="secphone#xpath=//*[@id='secondary_phone']"; 
	public static String Patient_DOS="DOS#xpath=//*[@id='date_of_service']"; 
	public static String Patient_Addprefcard="Addprefcard#xpath=//i[@class='fa fa-paperclip']"; 	 
	public static String Patient_AddprefcardPopUpText="AddprefcardPopUpText#xpath=//*[@class='modal-header']";
	public static String Patient_DeleteIcon="DeleteIcon#xpath=//i[@class='fa fa-trash-o']";
	



	//Cases
	public static String Cases_CasesPageLink="CasesPageLink#xpath=//a[@href='#/preference-card/cases']"; 
	public static String Cases_SelectDateDropDown="SelectDateDropDown#xpath=//*[@id='dateRange']"; 
	public static String Cases_SearchButton="SearchButton#xpath=//button[@type='submit']";
	public static String Case_firstPatient="firstPatient#xpath=(//*[@class='table table-striped']//tbody/tr/td[2]/nobr)[1]";
	public static String Case_firstCase="firstCase#xpath=//*[@class='table table-bordered']/tr//td[2]";
	// public static String Case_firstCase="firstCase#xpath=(//*[@class='table table-bordered'])[1]";
	public static String Cases_searchTextBox="searchTextBox#xpath=//*[@id='search']"; 
	public static String Cases_Editbutton="Editbutton#xpath=(//i[@class='fa fa-edit'])[1]";
	public static String Cases_EditCase="EditCase#xpath=//*[@class='pagehead ng-binding']";
	public static String Cases_Printbutton="Printbutton#xpath=(//i[@class='fa fa-print'])[1]";
	public static String Cases_PreviewPopUp="PreviewPopUp#xpath=//*[@class='modal-header']";

	//Procedures

	public static String Procedure_PageLink="PageLink#xpath=//*[@href='#/preference-card/procedures']";
	public static String Procedure_firstElem="firstElem#xpath=//table[@class='table table-striped']//tbody/tr[1]/td[1]";
	public static String Procedure_AddProcedure="AddProcedure#xpath=//a[@href='#/preference-card/procedure/create']";
	public static String Procedure_addName="addName#xpath=//input[@id='name']";
	public static String Procedure_SelectPhysican1="SelectPhysican1#xpath=(//*[@ng-click='setSelectedPhysicians()'])[1]";
	public static String Procedure_Physicians="Physicians#xpath=//*[@ng-model='suggestPhysicians']";
	public static String Procedure_SelectPhysican1Label="SelectPhysican1Label#xpath=(//*[@class='checkbox ng-scope'])[1]";
	public static String Procedure_SelectPhysican1Labe2="SelectPhysican2Label#xpath=(//*[@class='checkbox ng-scope'])[2]";
	public static String Procedure_HeaderProcedure="HeaderProcedure#xpath=//th/a[contains(text(),'Procedure')]";
	public static String Procedure_HeaderCPTCode="HeaderCPTCode#xpath=//th/a[contains(text(),'CPT Code')]";
	public static String Procedure_HeaderLastUpdateat="HeaderLastUpdateat#xpath=//th/a[contains(text(),'Last Updated at')]";
	public static String Procedure_Edit="Edit#xpath=//*[@title='Edit Procedure']";
	public static String Procedure_Delete="Delete#xpath=//*[@uib-tooltip='Delete Procedure']";
	public static String Procedure_DeleteValidation="Deletevalidation#xpath=//h2/following-sibling::p";
	public static String Procedure_EditHeader="EditHeader#xpath=//*[contains(text(),'Edit Procedure')]";
	public static String Procedure_SelectPhysican2="SelectPhysican2#xpath=(//*[@ng-click='setSelectedPhysicians()'])[2]";
	public static String Procedure_cptCode="cptCode#xpath=//input[@id='cpt_code']";	 
	public static String Procedure_SaveButton="SaveButton#xpath=//button[contains(text(),'Save')]";
	public static String Procedure_CloseButton ="CloseButton#xpath=//*[@value='Close']";
	public static String Procedure_SaveforChanges ="SaveforChanges#xpath=//*[contains(text(),'Save Form Changes.')]";
	public static String Procedure_Exitwithoutsave ="Exitwithoutsave#xpath=//button[text()='Exit Without Save']";
	public static String Procedure_SearchTextBox="SearchTextBox#xpath=//*[@id='search']";
	public static String Procedure_wait="wait#xpath=//*[@id='ng-view']";
	public static String Procedure_EditButton="EditButton#xpath=(//i[@class='fa fa-edit'])[1]";
	public static String Procedure_plusIcon="plusIcon#xpath=(//button[@class='btn btn-sm btn-default ng-scope'])[1]";
	public static String Procedure_DeleteButton="DeleteButton#xpath=(//i[@class='fa fa-trash-o'])[1]";
	public static String Procedure_waitForDelete="waitForDelete#xpath=//*[@class='pull-right']";
	public static String Procedure_ConfirmButton="ConfirmButton#xpath=//*[@class='confirm']";
	public static String Procedure_waitForConfirmButton="waitForConfirmButton#xpath=//*[@class='sa-confirm-button-container']";
	public static String Procedure_NoProcText="NoProcText#xpath=//table[@class='table table-striped']/thead/tr[2]/td";
	public static String Procedure_firstPhysician="firstPhysician#xpath=//table[@class='table table-bordered']//tbody/tr[1]/td";

	//PLANNER
	public static String Planner_PageLink="PageLink#xpath=//*[@href='#/preference-card/planner']";
	public static String Planner_FilterByPhysician="FilterByPhysician#xpath=//*[starts-with(@placeholder,'Filter by Physicians')]";
	public static String Planner_datatime630="datatime630#xpath=//tr[@data-time='06:30:00' and @class='fc-minor']";
	public static String Planner_createCaseHeading="createCaseHeading#xpath=(//*[@class='modal-header']//h4)";
	public static String Planner_createPatient="createPatient#xpath=//button[@ng-click='addPatientFn();']";
	public static String Planner_popUpText="popUpText#xpath=//*[@class='headtext']/span";
	public static String Planner_AddPatient="AddPatient#xpath=//*[@class='modal-footer']/button[@class='btn btn-primary pull-right ng-scope']";


	//User;s default FACILITy

	public static String Profile_defaultFacility="defaultFacility#xpath=(//*[@class='form-horizontal custom-form'])[2]//*[@class='form-group']//span";


	//PrefCard

	public static String prefCard_PageLink="PageLink#xpath=//*[@href='#/preference-card/cards']";
	public static String prefCard_wait="wait#xpath=//*[@id='ng-view']";
	public static String prefCard_AddPrefCard="AddPrefCard#xpath=//*[@href='#/preference-card/card/create']";
	// public static String prefCard_AddPrefCard="AddPrefCard#xpath=Patient_firstPatient
	public static String prefCard_CardName="CardName#xpath=//*[@id='cardName']"; 
	public static String prefCard_PhysicianName="PhysicianName#xpath=//*[@id='physician']";
	public static String Prefcard_CopyCard="CopyCard#xpath=//button[text()='Copy Card']";
	public static String prefCard_GlovesSize="GlovesSize#xpath=//*[@id='gloves_size']"; 
	public static String prefCard_addStage="addStage#xpath=//input[@value='Add Stage']";	 
	public static String prefCard_addStageText="addStageText#xpath=//*[@class='modal-header']/h4";
	public static String prefCard_CanelBUtton="CanelBUtton#xpath=//*[@class='modal-footer']//button[text()='Cancel']";
	public static String prefCard_addStageName="addStageName#xpath=//*[@id='prefCardStage']";
	public static String prefCard_addStageButton="addStageButton#xpath=//button[@class='btn btn-primary ng-binding']";
	public static String prefCard_reorderStageButton="reorderStageButton#xpath=//*[@value='Re-order Stage']";
	public static String prefCard_reorderStage_hash="hash#xpath=//*[@class='form-group']/h3[contains(text(),'#')]";
	public static String prefCard_reorderStage_Name="Name#xpath=//*[@class='form-group']/h3[contains(text(),'Name')]";
	public static String prefCard_firstStage="firstStage#xpath=//ul[@dnd-list='Ctrl.prefCardStages']/li[1]//p";
	public static String prefCard_secondStage="secondStage#xpath=//ul[@dnd-list='Ctrl.prefCardStages']/li[2]//p";
	public static String prefCard_DragfirstStage="DragfirstStage#xpath=//ul[@dnd-list='Ctrl.prefCardStages']/li[1]";
	public static String prefCard_DragsecondStage="DragsecondStage#xpath=//ul[@dnd-list='Ctrl.prefCardStages']/li[2]";
	public static String prefCard_addItemInCart = "addItemInCart#xpath=//button[@id='btnAdd']";
	public static String prefCard_searchInCart = "searchInCart#xpath=//*[@class='tab-pane ng-scope active']//input[@id='searchInput']";
	public static String prefCard_OpenQty = "OpenQty#xpath=(//*[@ng-click='openQtyForm.$show();'])[1]";
	public static String prefCard_OpenQtyIncrease = "OpenQtyIncrease#xpath=(//*[@ng-click='openQtyForm.$show();'])[1]/following-sibling::button[text()='+']";
	public static String prefCard_HoldQtyIncrease = "holdQtyIncrease#xpath=(//*[@ng-click='holdQtyForm.$show();'])[1]/following-sibling::button[text()='+']";
	public static String prefCard_HoldQty = "holdQty#xpath=(//*[@ng-click='holdQtyForm.$show();'])[1]";
	public static String prefCard_ItemDes = "ItemDes#xpath=(//*[@id='suggestions']//strong)[1]";
	public static String prefCard_Sku = "Sku#xpath=(//*[@id='suggestions']//*[@class='text-muted'])[2]";
	public static String prefCard_catName = "catName#xpath=(//tr//h4)[1]";
	public static String prefCard_OpenQtyValidation = "OpenQtyValidation#xpath=//*[text()='Open Quantity can not be less than zero.']";
	public static String prefCard_number = "number#xpath=//*[@type='number']";
	public static String prefCard_InitialopenQty = "InitialopenQty#xpath=//*[@editable-number='prefCardStageItem.open']//span";
	public static String prefCard_IntialHoldQty = "intialHoldQty#xpath=//*[@editable-number='prefCardStageItem.hold']//span";
	public static String prefCard_plusIconOpenQTY = "plusIconOpenQTY #xpath=//*[@editable-number='prefCardStageItem.open']//button[2]";
	public static String prefCard_plusIconHoldQTY= "plusIconHoldQTY#xpath=//*[@editable-number='prefCardStageItem.open']//button[2]";
	public static String prefCard_deleteQty= "deleteQty#xpath=(//i[@class='glyphicon glyphicon-trash'])[1]";
	public static String prefCard_confirmButton= "deleteQty#xpath=//button[@class='confirm']";
	public static String prefCard_NoItemText= "NoItemText#xpath=//h4[@class='text-center']";
	public static String prefCard_DeleteStage_validation= "Validation#xpath=//*[text()='Do you really want to remove the item from stage?']";
	public static String prefCard_removeStage="removeStage#xpath=//*[@ng-click='removeStage(prefCardStage)']";
	public static String prefCard_copyStages="copyStages#xpath=//input[@value='Copy Stages']";
	public static String prefCard_copyStagesPopUpText="copyStagesPopUpText#xpath=//*[@class='modal-header']//h4";
	public static String prefCard_copyPredCardDrpDown="copyPredCardDrpDown#xpath=//*[@id='prefCard']";
	public static String prefCard_copyPredCardStageDroppDown="copyPredCardStageDroppDown#xpath=//*[@id='prefCardStage']";
	public static String prefCard_addButtton="addButtton#xpath=//button[text()='ADD']";
	public static String prefCard_copyButtton="addcopyButtton#xpath=//button[text()='Copy']";
	public static String prefCard_ADDButtton="addButtton#xpath=//button[text()='ADD']";
	public static String prefCard_stageName="stageName#xpath=(//uib-tab-heading)[1]";
	public static String prefCard_saveButton="saveButton#xpath=//*[@ng-click='savePreferenceCard(preferenceCard)']";
	public static String prefCard_searchTextBox = "searchTextBox#xpath=//*[@id='search']";
	public static String prefCard_firstprefcard = "firstprefcard#xpath=//*[@class='table table-striped']//tr[1]/td[1]";
	public static String prefCard_removePrefCard = "removePrefCard#xpath=//i[@class='fa fa-trash-o']";
	public static String prefCard_NoPrefCardText = "NoPrefCardText#xpath=//td[@class='text-center']";
	public static String prefCard_copyCard= "copyCard#xpath=//i[@class='fa fa-file-o']";
	public static String prefCard_copyCardPopUpText= "copyCardPopUpText#xpath=//*[@class='modal-header']//h4";
	public static String prefCard_Copy_card_name= "card_name#xpath=//*[@id='card_name']";
	public static String prefCard_selectPhyscian= "Physcian#xpath=//*[@ng-model='searchParams.physician_id']";

	//Manage Inventory
	public static String manageInv_pageLink= "pageLink#xpath=//*[@href='#/inventory']";
	public static String manageInv_firstItemDesc= "firstItemDesc#xpath=(//*[@class='item-description']/span)[1]";
	public static String manageInv_wait2= "wait#xpath=//*[@id='ng-view']";
	public static String manageInv_searchTextBox= "searchTextBox#xpath=//*[@id='PONUM']";
	public static String manageInv_searchButton= "searchButton#xpath=//*[text()='Search']";
	public static String manageInv_firstItemSku= "firstItemSku#xpath=//*[@class='vendor_info ng-binding'][1]//span[2]";
	public static String manageInv_EditIem= "EditIem#xpath=//*[@class='glyphicon glyphicon-pencil text-success action-button']";
	public static String manageInv_actaulFac= "actaulFac#xpath=//*[@class='pagehead']//a";
	public static String manageInv_wait= "wait#xpath=//*[@id='itemmasterListing']";
	public static String manageInv_editItem= "editItem#xpath=(//*[@uib-tooltip='Edit']/i)[1]";
	public static String manageInv_InventoryTab = "InventoryTab#lnktext=Inventories";
	public static String manageInv_Inv_checkBoxes= "Inv_checkBoxes=#xpath=//*[contains(@id,'tbl_add_vendor')]//input[@type='checkbox']";
	public static String manageInv_SaveButton= "SaveButton=#xpath=//button[@type='submit']";
	public static String manageInv_confirmButton= "confirmButton=#xpath=//*[@class='confirm']";
	public static String manageInv_Stockitem= "Stockitem=#xpath=(//*[@ng-click='popp(item)'])[1]";
	public static String manageInv_Stockitem_Inventory= "name=#xpath=//*[@id='popoverTemplateH']";
	public static String manageInv_selectedFac= "selectedFac#xpath=//*[@ng-click='selectItem();']";
	public static String manageInv_EditIemHeaderText= "EditIemHeaderText#xpath=//*[@class='headtext']";
	public static String manageInv_VendorsTab = "VendorsTab#lnktext=Vendors";
	public static String manageInv_EditStockStatus= "EditStockStatus#xpath=//*[@name='stock_status']";
	public static String manageInv_EditItem_SaveButton="EditItem_SaveButton#xpath=//button[@type='submit']";
	public static String manageInv_EditItem_GPoContractPrice="EditItem_GPoContractPrice#xpath=//input[@ng-model='v.facilityItemVendors.gpo_contract_price']";
	public static String manageInv_DeleteIcon="DeleteIcon#xpath=//i[@class='glyphicon glyphicon-trash text-danger action-button']";
	public static String manageInv_cancelPopUP="cancelPopUP#xpath=//button[@class='cancel']";
	public static String manageInv_DeletePoUp="DeletePoUp#xpath=//*[@class='sweet-alert showSweetAlert visible']//p";
	public static String manageInv_PrintIcon="PrintIcon#xpath=(//*[@class='glyphicon glyphicon-print text-primary action-button'])[1]";
	public static String manageInv_PrintPreviewButton="PrintPreviewButton#xpath=//*[@ng-click='showPop()']";
	public static String manage_PrintCloseclose="PrintPReviewclose#xpath=//*[@class='fa fa-2x fa-times']";
	public static String manageInv_ItemName="ItemName#xpath=//*[@id='populate_items_pdf']//td[1]";
	public static String manageInv_TransferIcon="TransferIcon#xpath=(//*[@class='glyphicon glyphicon-transfer text-primary'])[1]";
	public static String manageInv_TransferPopUpText="TransferPopUpText#xpath=//*[@class='modal-header']/h4";
	public static String manageInv_PrintPopUpText="PrintPopUpText#xpath=//*[@class='headtext']/span";
	public static String manageInv_InventoryDropDown="InventoryDropDown#xpath=//*[@id='inventory']";
	public static String manageInv_minusSign="minusSign#xpath=//*[@class='glyphicon glyphicon-minus']";
	public static String manageInv_plusSign="plusSign#xpath=//*[@class='glyphicon glyphicon-plus']";
	public static String manageInv_cycleCount="cycleCount#xpath=(//*[text()='Cycle Count'])[1]";
	public static String manageInv_RequestPhysical="RequestPhysical#xpath=//button[text()='Request Physical count worksheet']";
	public static String manageInv_UPDATECount="UPDATECount#xpath=//*[text()='UPDATE COUNT']";
	public static String manageInv_Validation="Validation#xpath=//*[text()='Do you want to finish inventory count cycle?']";
	public static String manageInv_ValidationSucess="Validation#xpath=//*[text()='Cycle count updated successfully.']";
	public static String manageInv_Done="DONE#xpath=//button[text()='DONE']";
	public static String manageInv_Difference="Difference#xpath=//*[text()='Difference']";
	public static String manageInv_NewCount="NewCount#xpath=//*[@ng-model='item.newCount']";
	public static String manageInv_CycleCountUpdate="CycleCountUpdate#xpath=//*[text()='Cycle Count Updated']";
	public static String manageInv_selectedButton="selectedButton#xpath=//button[text()='Select']";
	public static String manageInv_selectedButtonFirst="selectedButton#xpath=(//button[text()='Select'])[1]";
	//Item Category

	public static String ItemCat_PageLink="PageLink#xpath=//*[@href='#/inventory/item-categories']";
	public static String ItemCat_pageContainerWait="pageContainerWait#xpath=//*[@id='isotopeContainer-']";
	public static String ItemCat_AddCategoryButton="AddCategoryButton#xpath=//*[text()='Add Category']";
	public static String ItemCat_createCatPopUpText="createCatPopUpText#xpath=//*[@class='headtext']/span[1]";
	public static String ItemCat_CatName="CatName#xpath=//*[@id='name']";
	public static String ItemCat_wait="wait#xpath=//*[@id='isotopeContainer-']";
	public static String ItemCat_SAveButton="SAveButton#xpath=//*[@ng-click='saveCategoryFn()']"; 
	public static String ItemCat_SearchTextBox="SearchTextBox#xpath=//*[@id='search']";
	public static String ItemCat_SearchButton="SearchButton#xpath=//*[text()='Search']";
	public static String ItemCat_firstCatName="firstCatName#xpath=//*[@id='isotopeContainer-']//*[@class='grid-heading grid-title-label ng-binding'][1]";
	public static String ItemCat_DeleteButton="DeleteButton#xpath=(//button[text()='Delete'])[1]";
	public static String ItemCat_ConfirmButton="ConfirmButton#xpath=//button[@class='confirm']";
	public static String ItemCat_NoRecordFoundText="NoRecordFoundText#xpath=//*[text()='No records found']";
	public static String ItemCat_NoDataAvailable="NoDataAvailableText#xpath=//*[text()='No data available']";
	public static String ItemCat_Import="Import#xpath=//button[text()='Import']";
	public static String ItemCat_vendorUpdatebtn="vendorUpdatebtn#xpath=//hyb-vendor-update-price/div";
	public static String ItemCat_vendorUpdateHeader="vendorUpdateHeader#xpath=//*[text()='Vendor Update']";
	public static String ItemCat_vendor_currentPrice="currentPrice#xpath=//*[text()='Current']";
	public static String ItemCat_vendorUpdate_Stockprice1="StockPrice1#xpath=(//*[text()='Stock Status']/following-sibling::div)[1]";
	public static String ItemCat_vendorUpdate_Stockprice2="StockPrice1#xpath=(//*[text()='Stock Status']/following-sibling::div)[2]";
	public static String ItemCat_vendorUpdate_Price="Price#xpath=(//*[text()='Price']/following-sibling::div)[1]";
	public static String ItemCat_vendorUpdate_Userbtn="Userbtn#xpath=//button[text()='Use']";
	public static String ItemCat_vendorUpdate_Cancelbtn="Cancelbtn#xpath=//button[text()='Cancel']";
	
	
//Pay
	public static String Pay= "Pay#xpath=//*[text()='Past Due Notice.']";
	

	//Print Barcodes Page
	public static String PrintBarcodes_PageLink="PageLink#xpath=//*[@href='#/inventory/print-barcodes-qrcodes']";
	public static String PrintBarcodes_wait="waitforForFIrst#xpath=//*[@id='ng-view']";
	public static String PrintBarcodes_firstItem="waitforForFIrst#xpath=(//*[@value='name'])[1]";
	public static String PrintBarcodes_firstItem11="waitforForFIrst#xpath=(//*[@class='table table-striped shopTable'])//tr[1]";
	public static String PrintBarcodes_headerText="headerText#xpath=//*[@class='pagehead']";
	public static String PrintBarcodes_SelectFac_title ="SelectFac_title#xpath=//*[text()='Select Facility']";
	public static String PrintBarcodes_SelectFAc="SelectFac_#xpath=//*[@ng-click='selectItem();']";
	public static String PrintBarcodes_text = "text#xpath=//*[contains(text(),'Print Barcodes/QRCodes for')]";
	public static String PrintBarcodes_searchTextBox="searchTextBox#xpath=//*[@id='search']";
	public static String PrintBarcodes_searchButton="searchButtonx#xpath=//button[text()='Search']";
	public static String PrintBarcodes_skuName="skuName#xpath=//tr[1]/td[3]";
	public static String PrintBarcodes_vendorLabel="PrintBarcodes_vendorLabel#xpath=//*[ng-submit='searchData();']//label[2]";
	public static String PrintBarcodes_vendordropdown="vendordropdown#xpath=//*[@id='vendor']";
	public static String PrintBarcodes_Inventorydropdown="Inventorydropdown#xpath=//*[@id='inventory']";
	public static String PrintBarcodes_InventoryLabel="PrintBarcodes_InventoryLabel#xpath=//*[ng-submit='searchData();']//label[3]";
	public static String PrintBarcodes_PrintCodesButton="PrintCodesButton#xpath=//*[@class='col-sm-18']//button[@type='button']";
	public static String PrintBarcodes_PrintCodesPopUp="PrintCodesPopUp#xpath=//*[@class='popover-content']//span";
	public static String PrintBarcodes_text01="Print_sheet_With#xpath=//*[@class='popover-content']//h4[text()='Print sheet With :']";
	public static String PrintBarcodes_text02="Generate_PDF#xpath=//*[@class='popover-content']//h4[text()='Generate PDF :']";
	public static String PrintBarcodes_text03="Print_With#xpath=//*[@class='popover-content']//h4[text()='Print With :']";
	public static String PrintBarcodes_text04="Print_Pages#xpath=//*[@class='popover-content']//h4[text()='Print Pages :']";
	public static String PrintBarcodes_PrintPagesTextBox="PrintBarcodes_PrintPagesTextBox#xpath=//label[@for='pages']/input";
	public static String PrintBarcodes_PrintPagesAllRadioButton="PrintPagesAllRadioButton#xpath=//*[@id='all']";
	public static String PrintBarcodes_SelectPagesRadioButton="SelectPagesRadioButton#xpath=//*[@id='pages']";
	public static String PrintBarcodes_PrintButton="PrintButton#xpath=//button[text()='Print']";
	public static String PrintBarcodes_PreviewPDFTEXT="PreviewPDFTEXT#xpath=//*[@class='modal-header']";
	public static String PrintBarcodes_PrintPReviewclose="PrintPReviewclose#xpath=//*[@class='fa fa-times']";
	public static String PrintBarcodes_sku1="sku#xpath=//*[contains(text(),'Print sheet With')]/following-sibling::div//*[@id='sku1' AND @type='radio']";
	public static String PrintBarcodes_MFRNumber="MFRNumber#xpath=.//*[contains(text(),'Print sheet With')]/following-sibling::div//*[@id='mfr' AND @type='radio']";
	public static String PrintBarcodes_Qucikcode="Qucikcode#xpath=//*[contains(text(),'Print sheet With')]/following-sibling::div//*[@id='qucikCode' AND @type='radio']";
	public static String PrintBarcodes_CWIIDD="CWIIDD#xpath=//*[contains(text(),'Print sheet With')]/following-sibling::div//*[@id='cross_walk_id' AND @type='radio']";
	public static String PrintBarcodes_PDF_Print="PDFPrint#xpath=//*[contains(text(),'Preview PDF')]";
	public static String PrintBarcodes_PDF_PrintClose="Close#xpath=//button[@class='close']";
	public static String print_header="Printheader#xpath=//*[text()='Print items Barcode/QRcode']";
	//SpecialInstructions

	public static String SI_PageLink="SI#xpath=//*[@href='#/po-special-instructions']";
	public static String SI_TableWait="searchTextBox#xpath=//*[@id='reqListing;]";
	public static String SI_AddButton="AddButton#xpath=//*[@class='pagehead']/button";
	public static String SI_AddPageHeaderText="AddPageHeaderText#xpath=//*[@class='headtext']";
	public static String SI_AddSITextBox="AddSITextBox#xpath=//*[@id='name']";
	public static String SI_SAveButton="SAveButton#xpath=//*[text()='Save']";
	public static String SI_SearchTextBox="SearchTextBox#xpath=//*[@id='search-search']";
	public static String SI_SearchButton="SearchButton#xpath=//*[text()='Search']";
	public static String SI_firstElem="firstElem#xpath=//*[@id='reqListing']//tr/td";
	public static String SI_EditItem="EditItem#xpath=(//*[@class='fa fa-edit'])[1]";
	public static String SI_DeleteButton="DeleteButton#xpath=(//*[@class='fa fa-trash'])[1]";
	public static String SI_closeButton="closeButton#xpath=//*[@ng-click='cancel()']";
	public static String SI_ConfirmButton="ConfirmButton#xpath=//*[@class='confirm']";

	//Manage Physician

	public static String Physician_PageLink="Physician#xpath=//*[@href='#/preference-card/physicians']";
	public static String Physician_AddPhysicianButton="AddPhysicianButton#xpath=//*[text()='Add Physician']";
	public static String SI_firstRow="firstRow#xpath=//*[@id='reqListing_wrapper']";

	//Invoice Payment Term
	public static String Pterms_PageLink="Pterms#xpath=//*[@href='#/invoice/payment-terms']";
	public static String Pterms_waitForTable="waitForTable#xpath=//*[@class='table table-striped']";
	public static String Pterms_AddPTermButton="AddPTermButton#xpath=//*[text()='Add Payment Term']";
	public static String Pterms_addDesc="addDesc#xpath=//*[@id='termDescription']";
	public static String Pterms_addDays="addDays#xpath=//*[@id='paymentTermDays']";
	public static String Pterms_addperc="addperc#xpath=//*[@id='paymentTermPercent']";
	public static String Pterms_addApiID="addApiID#xpath=//*[@id='ApIntegrationId']";
	public static String Pterms_saveButton="saveButton#xpath=//*[@class='modal-footer']/button";
	public static String Pterms_searchTextBox="searchTextBox#xpath=//*[@id='search-search']";
	public static String Pterms_firstItem="firstItem#xpath=//table[@class='table table-striped']//tbody/tr/td";
	public static String Pterms_firstItemAllAttributes="firstItemAllAttributes#xpath=//table[@class='table table-striped']//tbody/tr/td";
	public static String Pterms_EditIcon="EditIcon#xpath=//i[@class='fa fa-edit']";
	public static String Pterms_Deleteicon="Deleteicon#xpath=//i[@class='fa fa-trash-o']";
	public static String Pterms_headerTextEdit="headerTextEdit#xpath=//div[@class='modal-header']//span";
	public static String Pterms_closePopup="closePopup#xpath=//*[@class='modal-footer']//button[2]";
	public static String Pterms_confirmButton="confirmButton#xpath=//*[@class='confirm']";
	public static String Pterms_OKbutton="OKbutton#xpath=//*[@class='confirm']";
	//News

	public static String News_PageLink="News_PageLink#xpath=//*[@href='#/admin/news']";
	public static String News_addNews="addbtn#xpath=//*[@class='pagehead']//button[@ng-click='createNews()']";
	public static String News_addTitle="addTitle#xpath=//*[@id='title']";
	public static String News_add_AddnewsTitle="AddnewsTitle#xpath=//*[text()='Add News']";
	public static String News_addDec="addDec#xpath=//*[starts-with(@id,'taTextElement')]";
	public static String News_ActiveButtn="ActiveButtn#xpath=//*[@class='bootstrap-switch-container']//span[1]";
	public static String News_InActiveButtn="InActiveButtn#xpath=//*[@class='bootstrap-switch-container']//span[@class='bootstrap-switch-handle-off bootstrap-switch-default']";
	public static String News_ActiveInactiveClass="ActiveInactiveClass#xpath=//*[@class='col-sm-6 user-action-switch']/div[1]";
	public static String News_saveButton="saveButton#xpath=//*[@class='pagehead']//button[1]";
	public static String News_waitForNews="waitForNews#xpath=//*[@id='isotopeContainer-']";
	public static String News_searchTextBox="searchTextBox#xpath=//*[@id='search-search']";
	public static String News_searchButton="searchButton#xpath=//button[text()='Search']";
	public static String News_firstNews="firstNews#xpath=//*[@id='isotopeContainer-']//*[@class='grid-heading grid-title-label ng-binding']";
	public static String News_EditNews="EditNews#xpath=(//*[@ng-click='editNews(NewsData.id)'])[1]";
	public static String News_EditNewsText="EditNewsText#xpath=//*[@class='pagehead']/span[@ng-show='isEditMode']";
	public static String News_cancelNews="EditNewsText#xpath=//*[@ng-click='cancel()']";
	public static String News_deleteNews="deleteNews#xpath=(//*[@ng-click='deleteNews(NewsData.id)'])[1]";
	public static String News_confirmButton="confirmButton#xpath=//button[@class='confirm']";
	public static String News_NoRecordFound="NoRecordFound#xpath=//*[@id='isotopeContainer-']//*[text()='No records found']";
	public static String News_firstNewsa="firstNews#xpath=(//*[@id='isotopeContainer-']//*[@class='grid-heading grid-title-label ng-binding'])[1]";
	public static String News_UpdatedBy="UpdatedBy#xpath=(//*[text()='Update by:'])[1]";
	public static String News_Updatedat="Updatedat#xpath=(//*[text()='Updated at:'])[1]";
	public static String News_Updatedbyname="Updatedatname#xpath=(//*[text()='Update by:']/following-sibling::div)[1]";
	public static String News_Updatedatname="Updatedatname#xpath=(//*[text()='Updated at:']/following-sibling::div)[1]";
	public static String News_EditTitle="EditTitle#xpath=//*[text()='Edit News']";
	public static String News_UploadBtn="UploadBtn#xpath=//*[@value='Upload']";
	public static String News_UploadImgPath="UploadImgPath#xpath=//*[text()='Uploaded Image Path']";
	public static String News_Filepth="FilePath#xpath=//*[text()='Uploaded Image Path']/following-sibling::div/div[1]";
	
	//Vendor
	public static String Vendor_PageLink="Vendor_PageLink#xpath=//*[@href='#/admin/vendor']";	
	public static String Vendor_firstItem="Vendor_PageLink#xpath=(//*[@class='grid-heading grid-title-label ng-binding'])[2]";
	public static String Vendor_searchTextBox="searchTextBox#xpath=//*[@id='search-search']";
	public static String Vendor_searchButton="searchButton#xpath=//button[text()='Search']";
	public static String Vendor_waitForVendor="waitForVendor#xpath=//*[@id='isotopeContainer-']";
	public static String Vendor_status="Vendor_status#xpath=(//*[@class='pull-left']/span)[1]";
	public static String Vendor_EditButton="Vendor_EditButton#xpath=(//*[@class='grid-row-last']//button)";
	public static String Vendor_EditVendorPopup="Vendor_EditVendorPopup#xpath=//*[@class='headtext']/span[1]";
	public static String Vendor_waitForTabs="waitForTabs#xpath=//ul[@class='nav nav-tabs']";

	//PriceTier Setup

	public static String priceTier_PageLink="priceTier_PageLink#xpath=//*[@href='#/admin/pricetier']";	
	public static String priceTier_addPriceTier="addPriceTier#xpath=//*[@class='pagehead']//button[@ng-click='createPriceTier()']";
	public static String priceTier_addName="addName#xpath=//*[@id='tiername']";
	public static String priceTier_addpercentage="addpercentage#xpath=//*[@id='price_percentage']";
	public static String priceTier_saveButton="saveButton#xpath=//*[@class='modal-footer']//button[1]";
	public static String priceTier_searchTextBox="searchTextBox#xpath=//*[@id='search-search']";
	public static String priceTier_waitfor="waitfor#xpath=//*[@id='reqListing']";
	public static String priceTier_firstItem="firstItem#xpath=//*[@id='reqListing']//tr[1]//td[1]";
	public static String priceTier_EditButton="EditButton#xpath=//i[@class='fa fa-edit']";
	public static String priceTier_vendorSetup="vendorSetup#xpath=//*[@class='pagehead']//button[@ng-click='setVendorPriceTier()']";
	public static String priceTier_vendorPriceSetup="Vendor_vendorPriceSetup#xpath=//*[@class='headtext']/span[1]";
	public static String priceTier_DeleteButton="DeleteButton#xpath=//i[@class='fa fa-trash']";
	public static String priceTier_confirmButton="confirmButton#xpath=//*[@class='confirm']";
	public static String priceTier_OKbutton="OKbutton#xpath=//*[@class='confirm']";

	//Inventory Location
	public static String InvLoc_PageLink="InvLoc_PageLink#xpath=//*[@href='#/inventory-locations']";
	public static String InvLoc_Header="Header#xpath=//*[contains(text(),'Manage Inventory Locations')]";
	public static String InvLoc_AddINvLOc="AddINvLOc#xpath=//*[@class='pagehead']//button[text()='Add Inventory Location']";
	public static String InvLoc_addName="addName#xpath=//input[@id='desc']";
	public static String InvLoc_waitfortable="waitfortable#xpath=//*[@id='reqListing']";
	public static String InvLoc_addFacility="addFacility#xpath=//*[@name='facility']";
	public static String InvLoc_InactiveCreateButton="InactiveCreateButton#xpath=//*[@class='modal-footer']//button[1]";
	public static String InvLoc_searchTextBox="searchTextBox#xpath=//*[@id='search-search']";
	public static String InvLoc_Name="searchTextBox#xpath=//*[contains(text(),'Name')]";
	public static String InvLoc_row="row#xpath=(//*[@role='row'])[1]";
	public static String InvLoc_firstInventoryLoc="firstInventoryLoc#xpath=//*[@id='reqListing']//tbody//span[1]";
	public static String InvLoc_firstPlusIcon="firstPlusIcon#xpath=//*[@id='reqListing']//tbody//button[1]";
	public static String InvLoc_Added_INvenLoc="Added_INvenLoc#xpath=//ul[@class='facility_department_sublist']";
	public static String InvLoc_EditFacIcon="EditFacIcon#xpath=//i[@class='fa fa-edit']";
	public static String InvLoc_DeleteFacIcon="DeleteFacIcon#xpath=(//*[@class='fa fa-trash-o'])[1]";
	public static String InvLoc_Delete_ConfirmationYes="DeleteConfirmatinYEso#xpath=//button[text()='Yes']";
	public static String InvLoc_Delete_Confirmationcancel="DeleteConfirmationcancel#xpath=//button[text()='Cancel']";
	public static String InvLoc_confirmButton="confirmButton#xpath=//*[@class='confirm']";
	public static String InvLoc_Add_LabelName="Name#xpath=//label[contains(text(),'Name *')]";
	public static String InvLoc_Add_LabelFacilityName="FacilityName#xpath=//label[contains(text(),'Facility *')]";
	public static String InvLoc_Add_CreateBtn="Create#xpath=(//button[text()='Create'])[1]";
	public static String InvLoc_Add_CancelBtn="Cancel#xpath=(//button[text()='Cancel'])[1]";
	public static String InvLoc_Add_Facility_Dropdown="Facility_Dropdown#xpath=//*[@id='vendor']";
	public static String InvLoc_Add_PlusBtn="PlusBtn#xpath=(//button[text()='+'])[1]";
	public static String InvLoc_Add_MinusBtn="PlusBtn#xpath=(//button[text()='-'])[1]";
	public static String InvLoc_InventoriesText="InventoriesText#xpath=//*[text()='Inventories']";
	public static String InvLoc_Save="Save#xpath=//*[text()='Save']";
	public static String InvLoc_InventoryCount="InventoryCount#xpath=//*[@ng-if='inventoryLocation.expanded']/following-sibling::span[2]";
	public static String InvLoc_Add_PlusFacilityName="PlusFacilityName#xpath=(//button[text()='+'])[1]/following-sibling::span[1]";
	
	
	//Manage Inventory
	public static String AppPage_PageLink="AppPage_PageLink#xpath=//*[@href='#/approvals']";
	public static String AppPage_headerText="headerText#xpath=//*[@class='pagehead']";

	//Manufacturer
	public static String manufacturer_PageLink="manufacturer_PageLink#xpath=//*[@href='#/admin/manufacturers']";
	public static String manufacturer_headerText="headerText#xpath=//*[@class='pagehead']";
	public static String manufacturer_csManufacture="csManufacture#xpath=//*[text()='CS Manufacturers']";
	public static String manufacturer_wait="wait#xpath=//*[@id='isotopeContainer-']";
	public static String manufacturer_3rdVendor="3rdVendor=#xpath=//*[@id='isotopeContainer-']//*[@class='grid-item ng-scope'][3]";
	public static String manufacturer_searchTextBox="searchTextBox#xpath=//*[@id='search-search']";
	public static String manufacturer_searchby="searchbyText#xpath=//label[text()='Search by']";
	public static String manufacturer_searchButton="searchButton#xpath=//button[@type='submit']";
	public static String manufacturer_1stVendor="1stVendor#xpath=//*[@id='isotopeContainer-']//*[@class='grid-item ng-scope'][1]";
	
	// CS Manufacturers
	public static String csManufacture_Close="close#xpath=(//button[text()='Close'])[1]";
	public static String csManufacture_AddNewimport="AddNewimport#xpath=//button[text()='Add new & import']";
	
	//GL Code
	public static String glCode_PageLink="glCode_PageLink#xpath=//*[@href='#/admin/glcode']";
	public static String glCode_Home_Name="Name#classname=grid-heading";
	public static String glCode_Home_Code="Code#xpath=//*[text()='Code:']/following-sibling::div";
	public static String glCode_Home_Description="Description#xpath=//*[text()='Description:']/following-sibling::div";
	public static String glCode_Home_Deletefirst="DeleteButton#xpath=(//button[text()='Delete'])[1]";
	public static String glCode_Home_DeleteCancelbtn="DeleteCancelButton#xpath=//button[@class='cancel']";
	public static String glCode_Home_Editfirst="EditButton#xpath=(//button[text()='Edit'])[1]";
	public static String glCode_wait="wait#xpath=//*[@id='isotopeContainer-']";
	public static String glCode_addGlCOde="addGlCOde#xpath=//button[contains(text(),'Add')]";
	public static String glCode_add_Header="Header#xpath=//*[contains(text(),'Add GL Code')]";
	public static String glCode_add_Label_Code="Label_Code#xpath=//label[text()='Code*']";
	public static String glCode_add_Label_Name="Label_Name#xpath=//label[text()='Name*']";
	public static String glCode_add_Label_Description="Label_Description#xpath=//label[text()='Description']";
	public static String glCode_add_code="addCode#xpath=//*[@id='code']";
	public static String glCode_add_Name="addName#xpath=//*[@id='name']";
	public static String glCode_add_Desc="addDesc#xpath=//*[@id='description']";
	public static String glCode_saveButton="saveButton#xpath=//button[text()='Save']";
	public static String glCode_CloseButton="CloseButton#xpath=//button[text()='Close']";
	public static String glCode_searchTextBox="searchTextBox#xpath=//*[@id='search-search']";
	public static String glCode_searchButton="searchButton#xpath=//button[@type='submit']";
	public static String glCode_Deleteconfirmation="Deleteconfirmation#xpath=//*[text()='Are you sure you want to delete this GL Code ?']";
	
	public static String glCode_firstGlCOde="firstGlCode#xpath=//*[@id='isotopeContainer-']//*[@class='grid-heading grid-title-label ng-binding' and text()=''][1]";
	public static String glCode_deleteButton="deleteButton#xpath=(//*[@class='pull-right']//button[@ng-click='deleteGLCode(GLCodeData.id)'])[1]";
	public static String glCode_editButton="editButton#xpath=(//*[@class='pull-right']//button[@ng-click='editGLCode(GLCodeData.id)'])[1]";
	public static String glCode_NoRecordFound="NoRecordFound#xpath=//*[text()='No records found']";
	public static String glCode_confirmButton="confirmButton#xpath=//button[@class='confirm']";
	//Pattern
	public static String pattern_PageLink="pattern_PageLink#xpath=//*[@href='#/admin/pattern']";
	public static String pattern_wait="wait#xpath=//*[@id='reqListing_wrapper']";
	public static String pattern_addPattern="addPattern#xpath=//*[@class='pagehead']//*[@ng-click='createPattern()']";
	public static String pattern_addName="addName#xpath=//*[@id='name']";
	public static String pattern_selectFromTemplate="selectFromTemplate#xpath=//*[@id='sel_template']";
	public static String pattern_initialValue="initialValue#xpath=//*[@name='tpl_initial_value']";

	public static String pattern_plusIcon="plusIcon#xpath=//*[@id='btn_add_template']";
	public static String pattern_saveButton="saveButton#xpath=//*[@class='modal-footer']//button[1]";
	public static String pattern_firstPattern="firstPattern#xpath=//*[@id='reqListing']//tr[1]//td[1]";
	public static String pattern_deleteButton="deleteButton#xpath=(//*[@class='fa fa-trash'])[1]";
	public static String pattern_editButton="editButton#xpath=(//i[@class='fa fa-edit'])[1]";
	public static String pattern_gearButton="gearButton#xpath=(//*[@class='fa fa-gear'])[1]";
	public static String pattern_Sample_title="SampleTitle#xpath=//*[text()='Sample Pattern Value']";
	public static String pattern_IncreasedpatternValue="IncreasedpatternValue#xpath=//*[@class='modal-body']//h1";
	public static String pattern_confirmButton="confirmButton#xpath=//*[@class='confirm']";

	public static String pattern_trashButton="trashButton#xpath=//td[4]//i[@class='fa fa-trash']";
	
	    // Checkout
	    public static String Checkout_Btn ="CheckoutBtn#xpath=//*[@ng-click='gotoCart()']";
	    
	    // Price Change Details
	    public static String PriceChangeDetails_text = "PriceChangeText#xpath=(//*[text()='Price Change Details'])[1]";
	    public static String PriceChangeDetails_current_text = "CurrentPricetext#xpath=//strong[text()='Current Price']";
	    public static String PriceChangeDetails_Close = "close#xpath=//*[text()='Close']";
	    
	    // Purchace History
	    public static String purchaseHistory_itemPurchace_text = "itemPurchaceText#xpath=//*[contains(text(),'Item Purchase History')]";
	    
	    // Edit Item Page
	    public static String EditItem_text = "EditItem#xpath=(//*[text()='Edit Item'])[1]";
	    public static String EditItem_btn = "EditItem#xpath=(//button[contains(text(),'Edit Item')])[1]";
	    
	
		public static String Shop_drilldownRemoveLayout = "drilldownRemoveLayout#xpath=//a[contains(text(),'---automation layout---')]/../i";
			// admin
		public static String Admin_Vendor = "Vendor#xpath=//*[@href='#/admin/vendor']";
		public static String Admin_vendoraccountsetup = "vendoraccountsetup#xpath=//a[@href='#/admin/vendoraccountsetup']";

	
			  // Chat 
	    public static String Chat ="Chat#xpath=//*[@class='chat-directive']//em";
	    public static String Chat_Customerservice_txt ="Customerservice_txt#xpath=//*[contains(text(),'Customer Service')]";
	    public static String Chat_input ="ChatIntput#xpath=//*[@id='chat-textarea']";
	    public static String Chat_SendBtn ="ChatSendBtnIntput#xpath=//*[@id='btn-chat']";
	    public static String Chat_minimize ="chatMimize#xpath=//*[@class='panel-heading']//*[@src='images/minimize-small-white.png']";
	    public static String Chat_close ="Chatclose#xpath=//*[@class='panel-heading']//*[@src='images/cross-small-white.png']";
	    
	    // Order
	    public static String Order ="Myorder#xpath=//*[@href='#/orders']";
	    public static String Order_Departmentdetail_Name ="OrderName#xpath=//strong[text()='Department:']/following-sibling::text()";
	    public static String Order_PrintPOText="PrintPOText#xpath=(//*[@class='modal-header']//*[@class='ng-binding'])[1]";
	    public static String Order_Myorder_txt ="Myorder_txt#xpath=//div[contains(text(),'My Orders')]";
	    public static String Order_PrintPReviewclose="PrintPReviewclose#xpath=//*[@class='fa fa-times']";
	    public static String Order_Search_txt ="SearchTxt#xpath=//label[text()='Search:']";
	    public static String Order_dropDownIcon ="dropDownIcon#xpath=//*[@class='fa fa-chevron-down'][1]";
	    public static String Order_PrintPOLink="PrintPOLink#xpath=(//*[@class='dropdown-menu']//*[@ng-click='openPDF()'])[1]";
	    public static String Order_AdditemsToCart="AdditemsToCart#xpath=//li[@ng-if='allowAddToCart(order)']/a[@ng-click='AddOrderItemsTOCart(order);']";
	    public static String Order_CancelNotesPopUP ="CancelNotesPopUP#xpath=//*[@class='fa fa-2x fa-times']";
	    public static String Order_firstPONUm ="Order_firstPONUm#xpath=//*[@class='table']//tbody/tr/td[1]/a[1]";
	    public static String Order_DocsLink="DocsLink#xpath=(//*[@class='pull-right dropdown']/a[@ng-click='attachFiles(order)'])[1]";
	    public static String Order_CloseButton="CloseButton#xpath=//*[@ng-click='cancel()']";
	    public static String order_firstPOHeadingText="firstPOHeadingText#xpath=//*[@class='col-sm-18']/*[@class='pagehead ng-binding' and contains(text(),'Purchase Order #')]";
	    public static String Order_CloseButtonText="closeButton#xpath=(//button[@id='btnAdd'])[10]";
	    public static String Order_clcikNfacilityDropDown ="clcikNfacilityDropDown#xpath= //*[@id='facility']";
	    public static String Order_selectAllFromDropDown ="selectAllFromDropDown#xpath= //*[@id='facility']//ul[1]//li[1]//span[@class='ui-select-choices-row-inner']/span";
	    public static String Order_TextInDropDown ="TextInDropDown#xpath=//*[@id='facility']//span[@class='ng-binding ng-scope']";
	    public static String Order_searchButton ="searchButton#xpath=//button[@type='submit']";
	    public static String Order_Search_Input ="SearchInput#xpath=//*[@id='PONUM']";
	    public static String Order_Vendor_txt ="VendorTxt#xpath=//*[@for='vendor']";
	    public static String Order_Vendor_dropdown ="Vendoe_dropdown#xpath=//*[@id='vendor']//*[@class='ui-select-match-text pull-left']";
	    public static String Order_status_txt ="statusTxt#xpath=//*[@for='status']";
	    public static String Order_type_txt ="typeTxt#xpath=//*[@for='type']";
	    public static String Order_type_dropdown ="type_dropdown#xpath=//*[@id='type']//*[@class='ui-select-match-text pull-left']";
	    public static String Order_facility_txt ="facilityTxt#xpath=//*[@for='facility']";
	    public static String Order_facility_dropdown ="facility_dropdown#xpath=//*[@id='facility']//*[@class='ui-select-match-text pull-left']";
	    public static String Order_depts_txt ="deptsTxt#xpath=//*[@for='depts']";
	    public static String Order_depts_dropdown ="depts_dropdown#xpath=//*[@id='depts']//*[@class='ui-select-match-text pull-left']";
	    public static String Order_creater_txt ="createrTxt#xpath=//*[@for='creater']";
	    public static String Order_creater_dropdown ="creater_dropdown#xpath=//*[@id='creater']//*[@class='ui-select-match-text pull-left']";
	    public static String Order_SearrchBtn ="Search_Btn#xpath=//*[@type='submit']";
	  
	    public static String Order_PO_ID_First ="FirstPO#xpath=(//*[@ng-repeat='order in ordersData.purchaseOrders']//td/a)[1]";
	    public static String Order_wait="wait#xpath=//*[@class='table']/thead/tr";
	    public static String OrderDetails_Depatment="Depatment#xpath=(//select//option[@label='All Departments'])[1]";
		public static String OrderDetails_Physician="Physician#xpath=(//select//option[@label='All Physicians'])[1]";
		public static String OrderDetails_close="Close#xpath=//*[@class='pagehead ng-binding']//button[@class='close']";
		public static String Order_selectCreater="selectCreater#xpath=//*[@id='creater']//span[@class='ng-binding ng-scope']";
		public static String Order_UsersDropdown="UsersDropdown#xpath=//*[@name='creater']";
		
	    public static String Order_PO_Header ="PO_Header#xpath=//*[@class='pagehead ng-binding']";
	    public static String Order_PO_Notes_Icon ="PO_Notes_Btn#xpath=//*[@class='ng-scope fa fa-sticky-note-o']";
	    public static String Order_PO_Notes_HeaderTxt ="PO_Notes_HeaderTxt#xpath=//*[@class='headtext']//*[@class='ng-binding']";
	    public static String Order_PO_Notes_AddIcon_btn ="PO_Notes_Addbtn#xpath=//*[text()='Add New Note']";
	    public static String Order_PO_Notes_Input ="PO_Notes_Input#xpath=(//textarea)[1]";
	    public static String Order_PO_Notes_AddBtn ="AddBtn#xpath=//*[text()='Add']";
	    public static String Order_PO_Notes_DeleteBtn ="DeleteBtn#xpath=(//*[@class='fa fa-trash'])[1]";
	    public static String Order_PO_Notes_Deletevalidation ="Deletevalidation#xpath=//*[text()='Are you sure you want to delete this note?']";
	    public static String Order_PO_Notes_Delete_yes = "Delete_yes#xpath=//*[@class='confirm']";
	    public static String Order_PO_Notes_CloseBtn ="CloseBtn#xpath=//*[text()='Close']";
	    public static String Order_PO_Notes_Search ="Search#xpath=//*[@ng-model='search.noteSearch']";
	    public static String Order_PO_Notes_Search1 ="Search#xpath=//*[@ng-model='search.note']";
	    public static String Order_PO_Notes_Add_HeaderTxt ="PO_Notes_HeaderTxt#xpath=(//*[@class='headtext']//*[@class='ng-binding'])[1]";
	    public static String Order_PO_DocIcon ="DocumentIcon#xpath=(//button[@id='btnAdd'])[2]";
	    
	    public static String Order_PO_Doc_AfterUploadFiles ="Items#xpath=(//*[@ng-repeat='item in rows'])[1]";
	    public static String Order_PO_RevceiveOnly ="RevceiveOnly#xpath=//*[@uib-tooltip='Receive only']";
	    public static String OrderNotes_PO_First ="PO_NotesFirst#xpath=(//*[@ng-click='openPONote(order)']/i)[1]";
	    public static String OrderNotes_searchBox="searchBox#xpath=//input[@type='text']";
	    public static String OrderNotes_PO_NotesCount ="NotesCount#xpath=(//*[@ng-click='openPONote(order)']//sup)[1]";
	    public static String OrderNotes_PO_NotesClose ="Close#xpath=(//button[@ng-click='cancel()']/i)[1]";
	    
	    public static String OrderDoc_PO_First ="PO_DocFirst#xpath=(//*[@ng-click='attachFiles(order)']/i)[1]";
	    public static String OrderDoc_PO_NotesCount ="DocCount#xpath=(//*[@ng-click='attachFiles(order)']//sup)[1]";
	    public static String OrderDoc_PO_Doc_Icon ="PO_Doc_Btn#xpath=//i[@class='ng-scope fa fa-paperclip']";    
	  
	    public static String Order_selectDefaultUser="selectDefaultUser#xpath=//*[@id='facility']//span[@class='ng-binding ng-scope']";
		public static String Order_facilityDropdown="facilityDropdown#xpath=//*[@id='facility']";
	    
	    
	    
	    // order details
	    public static String OrderDetails_PO_getQty ="PO_getQty#xpath=//i[@class='ng-scope fa fa-paperclip']";
	    public static String OrderDetails_PO_Qty_Increase ="Qty_Increase#xpath=(//*[@ng-click='incrementQty(poItem.item_vendor_id, orderData.order.id,poItem.requested_qty, false)'])[1]";
	    public static String OrderDetails_PO_Qty_Decreasse ="Qty_Decreasse#xpath=(//*[@ng-click='decrementQty(poItem.item_vendor_id, orderData.order.id,poItem.requested_qty, false)'])[1]";
	    public static String OrderDetails_PO_Dropdown ="PO_Dropdown#xpath=//button[@ng-click='getInvoiceData(orderData.order);']";
	    public static String OrderDetails_PO_Validationn ="Validation#xpath=//*[text()='You have some unsaved changes in this order, do you want to save them before leaving the page?']";
	    public static String OrderDetails_InvoiceInput ="InvoiceInput#xpath=//*[@id='txtInvNo']";
	    public static String OrderDetails_Invoice_validation ="Validatiom#xpath=//*[text()='Do you want to save invoice?']";
	    public static String OrderDetails_PO_Dropdown_AddItemsTocart ="Dropdown_AddItemsTocart#xpath=//*[@ng-click='AddOrderItemsTOCart();']";
	    public static String OrderDetails_Btn_GeneratePo ="GeneratePo#xpath=//*[@tour-step-title='Cart: More Options']/button";
	    public static String OrderDetails_Btn_ClearAllCart ="ClearAllCart#xpath=//a[@ng-click='clearCart()']";
	    public static String OrderDetails_DeleteConfirmion="DeleteConfirmion#xpath=//*[text()='Are you sure you want to clear cart?']";
	    public static String OrderDetails_DeleteSucessConfirmion="DeleteSucessConfirmion#xpath=//*[text()='Cart cleared successfully.']";
	    public static String OrderDetails_HeaderDropdown="HeaderDropdown#xpath=//*[@tour-step='order-detail-more']/button";
	    public static String OrderDetails_AdditemsToCart="AdditemsToCart#xpath=//li[@ng-if='allowAddToCart()']/a[@ng-click='AddOrderItemsTOCart();']";
	    public static String OrderDetails_AddOrderItemsTOCart="AddOrderItemsTOCart#xpath=//a[@ng-click='AddOrderItemsTOCart();']";
	    public static String OrderDetails_AddInvoice="AddInvoice#lnktext=Add Invoice";
	    public static String OrderDetails_AddItem_validation="validation#xpath=//*[text()='All the items of order already added in the cart.']";
	    public static String Confirmionok="Confirmionok#xpath=//*[@class='confirm' and text()='OK']";
	    public static String OrderDetails_PrintItems="PrintItems#xpath=//*[text()='Print Items']";
	    public static String Orderdetails_Delete="Delete#xpath=//*[@ng-click='delItem($index)']";
	    public static String Orderdetails_Delete1="Delete#xpath=(//*[@ng-click='delItem($index)'])[1]";
	    public static String OrderDetails_PrintItems_Sku="Sku#xpath=//*[@id='sku1']";
	    public static String OrderDetails_PrintItems_Sku1="Sku#xpath=//*[@id='sku']";
	    public static String OrderDetails_PrintItems_mfr="mfr#xpath=//*[@id='mfr']";
	    public static String OrderDetails_PrintItems_qucikCode="qucikCode#xpath=//*[@id='qucikCode']";
	    public static String OrderDetails_PrintItems_Barcode="Barcode#xpath=//*[@id='populate_items_pdf']/tr/td[2]/img";
	    public static String OrderDetails_PrintItems_cross_walk_id="cross_walk_id#xpath=//*[@id='cross_walk_id']";
	    public static String OrderDetails_PrintItems_barcode="barcode#xpath=//*[@id='barcode']";
	    public static String OrderDetails_PrintItems_qrcode="qrcode#xpath=//*[@id='qrcode']";
	    public static String OrderDetails_OrderItems="OrderItems#xpath=//*[text()='Order Items']";
	    public static String OrderDetails_PrintItems_download="download#xpath=//*[@id='download']";
	    public static String OrderDetails_POApprovalLog="POApprovalLog#xpath=//*[text()='PO Approval Log']";
	    public static String OrderDetails_DeletePO="DeletePO#xpath=//a[text()='Delete PO']";
	    public static String OrderDetails_DeletePOValidation="ValidationDeletePO#xpath=//h2[text()='Delete PO']";
	    public static String OrderDetails_ShowTour="ShowTour#xpath=//a[text()='Show Tour']";
	    public static String OrderDetails_Dept="Dept#xpath=//p/vendor-info/span";
	    public static String OrderDetails_Physision="Physision#xpath=(//select[@ng-model='poItem.physician_id'])[1]";
	    public static String OrderDetails_Dept1="Dept#xpath=(//select[@ng-model='poItem.department_id'])[1]";
	    public static String OrderDetails_Close="Close#xpath=//span[@id='btnAdd' and contains(text(),'Close')]";    
	    public static String OrderDetails_MyOrderTxt="MyOrderTxt#xpath=//div[contains(text(),' My Orders')]";
	    public static String OrderDetails_infos="detailinfo#xpath=//*[@class='popover ng-scope ng-isolate-scope right fade in']";
	    public static String OrderDetails_ToltipMarkAsReceivedd="TooltipMarkAsReceived#xpath=//*[@class='tootip ng-scope ng-isolate-scope left in']";
	    public static String OrderDetails_tootlipvaliadtion="tooltip#xpath=//*[@class='tootip ng-scope ng-isolate-scope left in']";
	    public static String OrderDetails_valiadtion="validation#xpath=//*[text()='Will change this order to Receive Only order. Do you want to perform this action ?']";
	    public static String OrderDetails_valiadtionnon="validation#xpath=//*[text()='Will change this order to non Receive Only order. Do you want to perform this action ?']";
	    public static String OrderDetails__FacilityName="FacilityName#xpath=//strong[text()='Facility:']//ancestor::div[1]";
	    public static String OrderDetails_FacilityName="FacilityName#xpath=//*[text()='Facility:']";
	    public static String OrderDetails__DeptName="DeptName#xpath=//*[text()='Department:']";
	    public static String OrderDetails_DeptName="DeptName#xpath=//strong[text()='Department:']//ancestor::div[1]";
	    public static String OrderDetails_Change_Facility_Department="Change_Facility_Department#xpath=//*[contains(text(),'Change Facility/Department')]";
	    public static String OrderDetails_ShippingAddress="ShippingAddress#xpath=//format-address/address";
	    public static String OrderDetails_SpecialInstruction="SpecialInstruction#xpath=(//hyb-special-instructions//*[text()='Special Instructions'])[1]";
	    public static String OrderDetails_User="User#xpath=//*[contains(text(),'Created by')]/user-info";
	    public static String OrderDetails_userinfo="useringo#xpath=//*[contains(text(),'Created by')]";
	    public static String OrderDetails_Approvedinfo="ApprovedUser#xpath=//*[contains(text(),'Approved by')]";
	    public static String OrderDetails_TotalPo="TotalPo#xpath=//h5[@class='ng-binding']";
	    public static String OrderDetails_Alert="Alert#xpath=//*[text()='Changing the ship to location would put the PO again in approval flow of new facility.']";
	    public static String OrderDetails_itemToolTipDetails="ToolTip#xpath=//*[@class='popover ng-scope ng-isolate-scope top fade in']";
	    public static String OrderDetails_itemDropdown="ItemDropdown#xpath=//*[@id='POItems']";
	    
	    // Approve Item
	    public static String ApproveItem="ApproveItem#xpath=//*[@href='#/bill-only-items']";
	    
	    // Invoice Details
	    public static String Invoice_POFor="POFor#xpath=//*[text()='PO # for :']";
	    public static String Invoice_POFor_Number="PONumber#xpath=//user-info";
	    public static String Invoice_Date_label="Invoice_DateLabel#xpath=//*[text()='Invoice Date:*']";
	    public static String Invoice_Date="Invoice_Date#xpath=//*[@id='txtCreationDate']";
	    public static String Invoice_DueDate_label="InvoiceDueDate#xpath=//*[text()='Invoice Due Date:']";
	    public static String Invoice_DueDate="InvoiceDueDatetxtDueDate#xpath=//*[@for='txtDueDate']/following-sibling::div//*[@class='ng-binding']";
	    public static String Invoice_POTotalcost_label="POTotalCost#xpath=//*[text()='PO total cost:']";
	    public static String Invoice_POTotalcost="POTotalCost#xpath=//*[text()='PO total cost:']/following-sibling::div//*[@class='ng-binding']";
	    public static String Invoice_Totalcost_label="TotalCost#xpath=//*[text()='Total Invoice Price:']";
	    public static String Invoice_Totalcost="TotalCost#xpath=//*[text()='Total Invoice Price:']/following-sibling::div//*[@class='ng-binding']";
	    public static String Invoice_TotalState_TaxLabel="TotalState_TaxLabel#xpath=//*[text()='Tax (State + Local):']";
	    public static String Invoice_TotalState="TotalState#xpath=//*[@id='TaxAmount']";
	    public static String Invoice_FreightAmount_TaxLabel="FreightAmount_Label#xpath=//*[text()='Freight Charges:']";
	    public static String Invoice_Freight_Amount="FreightAmount#xpath=//*[@id='FreightAmount']";	    
	    public static String Invoice_DiscountAmount_TaxLabel="DiscountAmount_Label#xpath=//*[text()='Discount Amount:']";
	    public static String Invoice_Discount_Amount="DiscountAmount#xpath=//*[@id='DiscountAmount']";
	    public static String Invoice_InvoiceLabel="Invoice#xpath=//*[text()='Invoice #:*']";
	    public static String Invoice_BatchLabel="Batch#xpath=//*[text()='Batch#:']";
	    public static String Invoice_Batch_Input="Invoice#xpath=//*[@id='batchNumber']";
	    
	    // Templates
	    public static String Templateslink="Templates#xpath=//*[@href='#/templates']";
	    public static String Templates="Templates#xpath=//*[text()='Templates']";
	    public static String Templates_SearchTemplate_Txt="SearchTemplate#xpath=//*[text()='Search Template By:']";
	    public static String Templates_Header_TemplateName="TemplateName#xpath=//*[contains(text(),'Template Name')]";
	    public static String Templates_Header_CreatedBy="CreatedBy#xpath=//*[contains(text(),'Created By')]";
	    public static String Templates_Header_LastUpdate="LastUpdate#xpath=//*[contains(text(),'Last Updated at')]"; 	
	    public static String Templates_MyTemplate="MyTemplates#xpath=//*[contains(text(),'My Templates')]";
	    public static String Templates_AddBtn="Add#xpath=//*[@ng-click='createTemplate()']";
	    public static String Templates_VendorGroup="VendorGroup#xpath=//*[text()='View Group By Vendors?']";
	    public static String Templates_Receiveonly="Receiveonly#xpath=//*[@ng-model='vendor.is_receive_only']";
	    public static String Templates_isConsignment="isConsignment#xpath=//*[@ng-model='vendor.isConsignment']";
	    public static String Templates_VendorGroupCheckbox="VendorGroupCheckbox#xpath=//*[@ng-change='stateChanged(groupedItems)']";
	    public static String Templates_AddTemplatetxt="AddTemplatetxt#xpath=//*[@class='headtext']//*[text()='Add Template']";
	    public static String Templates_Name="Name#xpath=//*[@id='tempName']";
	    public static String Templates_Name_txt="Name#xpath=//*[@for='tempName']";
	    public static String Templates_CreateTemplate="CreateTemplate#xpath=//*[contains(text(),'Create Template')]";
	    public static String Templates_refreshValidation="Validation#xpath=//*[text()=\"You have some unsaved changes in this template, do you want to save them before we refresh the page for updated template's detail?\"]";
	    public static String Templates_Cancel="Cancel#xpath=//*[@class='modal-footer']//button[text()='Cancel']";
	    public static String Templates_Edit="Edit#xpath=//*[@class='fa fa-edit']";
	    public static String Templates_EditName="EditName#xpath=//form/div/input";
	    public static String Templates_EditSubmit="EditSubmit#xpath=//*[@title='Submit']";
	    public static String Templates_UsePo="UsePo#xpath=//*[@ng-model='poData.po']";
	    public static String Templates_Editview="Editview#xpath=//*[@onbeforesave='updateTemplate()']";
	    public static String Templates_SearchScan="SearchScan#xpath=//*[@id='searchInput']";
	    public static String Template_Add_First = "Add#xpath=(//*[@id='btnAdd'])[1]";
	    public static String Template_POSettings = "POSettings#xpath=//*[text()='PO Settings']";
	    public static String Template_HeaderPOSettings = "HeaderPOSettings#xpath=//*[contains(text(),'Template PO Settings')]";
	    public static String Template_AlertWindow = "AlertWindow#xpath=//*[@ class='alert alert-info']";
	    public static String Template_Uncheck_groupBYVendor = "groupBYVendor#xpath=//*[@class='pull-right']//input[@ng-model='groupedItems']";
	    public static String Template_VerifytempName = "VerifytempName#xpath=//*[@editable-text='tempData.template_name']";
	    public static String Template_addItemInCart = "addItemInCart#xpath=(//*[@class='pull-right']//button[@id='btnAdd'])[1]";
	    public static String Template_Schedule = "Schedule#xpath=//*[text()='Schedule']";
	    public static String Template_Schedule_No = "NoSchedule#xpath=//*[text()='No schedule for the template']";
	    public static String Template_Schedule_Header = "ScheuleTemplate#xpath=//*[contains(text(),'Schedule Template')]";
	    public static String Template_Schedule_Hour = "NoSchedule#xpath=//*[@ng-model='myFrequency.hourValue']";
	    public static String Template_Schedule_minuteValue = "minuteValue#xpath=//*[@ng-model='myFrequency.minuteValue']";
	    public static String  Template_Facility = "Facility#xpath=//*[@for='facility']/following-sibling::span";
	    public static String Template_Items = "Items#xpath=//*[text()='Items']";
	    public static String Template_AttachDepartment = "AttachDepartment#xpath=(//*[contains(text(),'Attach Department')])[1]";
	    public static String Template_Qty = "Qty#xpath=//*[text()='Qty']";
	    public static String Template_CutoffTime = "CutoffTime#xpath=//*[@ng-if='(vendor.is_cut_off_time | convertInt)']";
	    public static String Template_payment_term = "payment_term#xpath=//*[@ng-if='vendor.payment_term']";
	    public static String Template_ReorderHeader = "ReorderHeader#xpath=//*[contains(text(),'Template Items Re-order')]";
	    public static String Template_ReorderHeader1 = "ReorderHeader#xpath=//*[contains(text(),'Re-order Template Items')]";
	    public static String Template_QTYBOX = "QTYBOX#xpath=(//*[@class='item-qty-editable-label ng-binding'])[1]";
	    public static String Template_AddSchedule = "AddSchedule#xpath=//button[text()='Add Schedule']";
	    public static String Template_Schedule_Every = "Schedule_Every#xpath=//select[@ng-options='item.value as item.label for item in frequency']/option";
	    public static String Template_Schedule_Savebtn = "Savebtn#xpath=(//button[text()='Save'])[1]";
	    public static String Template_Schedule_ScheduleDetails = "ScheduleDetails#xpath=//*[@ng-repeat='sch in schedule']//*[@class='ng-binding ng-scope']";
	    public static String Template_Schedule_Deletebtn = "Deletebtn#xpath=//a[@uib-tooltip='Delete']";
	    public static String Template__Deletevalidation = "validation#xpath=//*[text()='Are you sure?']";
	    public static String Template__Deletevalidation1 = "validation#xpath=//*[text()='Are you sure you want to delete this schedule ?']";
	    public static String Template__Deletetemplatevalidation = "validation#xpath=//*[text()='Are you sure you want to delete this template ?']";
	    public static String Template_Yes = "Yes#xpath=//button[text()='Yes']";
	    public static String Template_Schedule_Toggle="Schedule_Toggle#xpath=//*[@class='table ng-scope']//tbody//tr[1]//td[2]//*[@class='pull-right']/div[1]";
	    public static String Template_Schedule_Toggleclass="Schedule_Toggle#xpath=//*[@class='table ng-scope']//tbody//tr[1]//td[2]//*[@class='pull-right']/div[1]";
	    public static String Template_deleteSchedule="deleteSchedule#xpath=//*[@class='pull-right']//a[@ng-click='deleteSchedule(sch.id, sch.template_id)']/i";
	    public static String Template_confirmButton="Schedule_confirmButton#xpath=//button[@class='confirm']";
	    public static String Template_Noschedule="NOSchedule#xpath=//*[@class='table ng-scope']//tbody//tr/td[1]";
	    public static String Template_NoTemplate="NoTemplate#xpath=//*[@class='table table-striped']//tbody//tr/td[1]";
	    public static String Template_closeButton="closeButton#xpath=//*[@class='pagehead']//button[text()='Close']";
	    
	    public static String Template_HeaderText="HeaderText#xpath=//*[@class='pagehead']";
	    
	    public static String Template_SAveTemplate="SaveTemplate#xpath= //button[@ng-click='updateTemplate()']";
	    public static String Template_UseTemplate="UseTemplate#xpath= (//*[@ng-if='template.is_use_access==1'])[1]";
	    public static String Template_selectHourValue = "electHourValue#xpath=//*[@class='form-inline']//*[@class='select-options']//select[2]";
	    public static String Template_changeHour = "changeHour#xpath=//*[@class='table ng-scope']//tbody//tr//td/span";
	    public static String Template_Schedule_EditButton = "Schedule_EditButton#xpath=//*[@class='pull-right']//i[@class='fa fa-edit']";
	    public static String Template_Cancel = "Cancel#xpath=//button [text()='Cancel']";	    
	    public static String Template_TostSucess = "TostSucess#xpath=//*[@class='toast-title']";
	    public static String Template_TostMsg = "Tostmsg#xpath=//*[@class='toast-message']";
	    public static String Template_Search_Input ="SearchInput#xpath=//*[@id='PONUM']";
	    public static String Template_SearchBtn ="SearchBtn#xpath=//button[text()='Search']";
	    public static String Template_dd_Edit ="Edit#xpath=//*[@class='dropdown-menu' and contains(@style,'display: block;')]//*[contains(text(),'Edit')]";
	    public static String Template_dd_PriceChangeDetails ="PriceChangeDetails#xpath=//*[@class='dropdown-menu' and contains(@style,'display: block;')]//*[contains(text(),'Price Change History')]";
	    public static String Template_dd_PurchaseHistoryt ="PurchaseHistory#xpath=//*[@class='dropdown-menu' and contains(@style,'display: block;')]//*[contains(text(),'Purchase History')]";
	    public static String Template_circleIcons ="circleIcons#xpath=//*[@class='item-info-icon-padd']";
	    public static String Template_MinQty ="MinQty#xpath=(//*[@ ng-if=\"item.min_order_qty != '0'\"])[1]";
	    public static String Template_SaveBtn ="SaveBtn#xpath=//button[text()='Save']";
	    public static String Template_CloseBtn ="Close#xpath=//button[text()='Close']";
	    public static String Template_Color ="Color#xpath=(//*[@class='item-info-icon-padd']//*[@data-toggle='tooltip'])[1]";
	    public static String Template_ShareYes ="ShareYes#xpath=//*[@class='bootstrap-switch-container']//*[text()='Yes']";
	    public static String Template_ShareNo ="ShareNo#xpath=//*[@class='bootstrap-switch-container']//*[text()='No']";
	    public static String Template_Edit ="Edit#xpath=(//i[@class='fa fa-edit'])[1]";
	    public static String Template_firstTemplate ="irstTemplate#xpath=//*[@class='table table-striped']//tbody//tr[1]/td[1]";
	    public static String Template_Delete ="Delete#xpath=(//i[@class='fa fa-trash-o'])[1]";
	    public static String Template_Use ="Use#xpath=(//a[@uib-tooltip='Use'])[1]";
	    public static String Template_GeneratePO ="GeneratePO#xpath=//*[@id='btnAdd']";
	    public static String Template_Warning ="Warning#xpath=//h2[text()='Warning']";
	    public static String Template_WarningMsg ="WarningMsg#xpath=//*[text()='Increase qty. of at least one item to generate the PO.']";
	    public static String Template_Warningok ="ok#xpath=//button[text()='OK']";
	    public static String Template_Plus ="Plus#xpath=//button[text()='+']";
	    public static String Template_Use_AddItem_Label ="AddItem_Label#xpath=//*[text()='Add Item:']";
		
	    // Scan Out
		public static String Scanout ="Scanout#xpath=//*[contains(text(),'Scan out')]";
		public static String Scanout_btn ="Scanoutbtn#xpath=(//*[@id='btnAdd' and contains(text(),'Scanout')])[1]";
		public static String Scanout_btn1 ="Scanoutbtn#xpath=(//*[@id='btnAdd' and contains(text(),'Scanout')])[2]";
		public static String Scanout_Scanout ="Scanout#xpath=//*[@href='#/inventory/scan-out']";
		public static String Scanout_scannedoutItem ="scannedoutItem#xpath=//*[@href='#/inventory/scanned-out-items']";
		public static String Scanout_SearchSku ="SearchSku#xpath=//*[@id='search']";
		public static String Scanout_SearchComment ="comment#xpath=//*[@id='scanOutComment']";
		public static String Scanout_Inventory ="Inventory#xpath=//*[contains(text(),'Inventory')]/following-sibling::select";
		public static String Scanout_Scanoutitem ="Scanoutitembtn#xpath=//*[@ng-click='goToScanOutItems()']";
		public static String Scanout_Searchbtn ="Search#xpath=//button[contains(text(),'Search')]";
		public static String Scanout_Minus ="Minux#xpath=//button[contains(text(),'-')]";
		public static String Scanout_plus ="Plus#xpath=//button[contains(text(),'+')]";
		public static String Scanout_Qty ="qty#xpath=(//nobr/span)[1]";
		public static String Scanout_Input_Qty ="input_Qty#xpath=//*[@role='form']//input";
		public static String Scanout_Complete ="Complete#xpath=//button[contains(text(),'Complete')]";
		public static String Scanout_Close ="Close#xpath=//button[contains(text(),'Close')]";
		public static String Scanout_Input_validation ="validation#xpath=//*[text()='Unit can not be less than Zero.']";
	
	    
	    // REport
	    public static String Report="Report#xpath=//a[@href='#/reports/activity-report']";
	    public static String Report_ViewMoreREports="ViewMoreREports#xpath=//button[contains(text(),'View More Reports')]";
	    
	    // Preferred card
	    public static String preferenceCard="preferenceCard#xpath=//*[@href='#/preference-card/cards']";	
	    public static String preferenceCard_AddPreferenceCard="AddPreferenceCard#xpath=//a[@href='#/preference-card/card/create']";
	    public static String preferenceCard_AddStage="AddStage#xpath=//*[@value='Add Stage']";
	    public static String preferenceCard_AddStageHeader="AddStage#xpath=//*[@class='modal-header']//*[contains(text(),'Add Stage')]";
	    public static String preferenceCard_InputAddStage="InputAddStage#xpath=//*[@id='prefCardStage']";
	    public static String preferenceCard_BtnAddStage="BtnStage#xpath=//button[text()='Add Stage']";
	    public static String preferenceCard_Reorder="Reorder#xpath=//button[text()='Reorder items']";
	    public static String preferenceCard_SearchItem="SearchItem#xpath=//*[@id='searchInput']";
	    public static String preferenceCard_AddItem="AddItem#xpath=//button[@id='btnAdd']";
	    
	    // Paitent
	    public static String Paintet="Paintet#xpath=//*[@href=\"#/preference-card/patients\"]";
	    public static String Paintet_First="FirstPaintet#xpath=(//button[contains(text(),'+')])[1]";
	    
	    public static String Paintet_FirstPhysician="FirstPaintetPhysician#xpath=(//*[@ng-repeat-start='patient in patients']/td)[1]";	    
	    // cases
	    public static String Cases ="Cases#xpath=//a[@href='#/preference-card/cases']";
	    public static String Cases_dateRange ="dateRange#xpath=//*[@id='dateRange']";
	    public static String Cases_searchbutton="searchbutton#xpath=//button[@type='submit']";	    
	    public static String PaginationLast="PaginationLast#xpath=//*[@class='pagination-last ng-scope']/a";

	    //Approve PO
	    
	    public static String ApprovePOLink ="ApprovePOLink#xpath=//a[@href='#/orders/approve']";
	    public static String ApprovePO_Menu_PO ="PO#xpath=//a[contains(text(),'PO #')]";
	    public static String ApprovePO_Menu_VendorName ="VendorName#xpath=//*[contains(text(),'Vendor Name')]";
	    public static String ApprovePO_Menu_ShopApp ="ShowApp#xpath=//*[@ng-if='showAppTourBtn']";
	    public static String ApprovePO_Menu_Status ="Status#xpath=//th[contains(text(),'Status')]";
	    public static String ApprovePO_Menu_RequestedCost ="RequestedCost#xpath=//a[contains(text(),'Requested Cost')]";
	    public static String ApprovePO_Menu_ReceivedCost ="ReceivedCost#xpath=//th[contains(text(),'Received Cost')]";
	    public static String ApprovePO_Menu_CreatedAt ="CreatedAt#xpath=//a[contains(text(),'Created At')]";
	    public static String ApprovePO_Menu_Buyer ="Buyer#xpath=//th[contains(text(),'Buyer')]";
	    public static String ApprovePO_Status="ApprovePO_Status#xpath=//*[@class='table']//tr//th[3]";
	    public static String ApprovePO_Unapproved="ApprovePO_Unapproved#xpath=//*[@class='table']//tr[1]//td[3]";
	    public static String ApprovePO_OrdestoApprove_txt ="OrdestoApprove_txt#xpath=//div[contains(text(),'Orders to Approve')]";
	    public static String ApprovePO_PrintPOLink="PrintPOLink#xpath=(//*[@class='dropdown-menu']//*[@ng-click='downloadPdf(order)'])[1]";
	    
	    public static String ApprovePO_PrintPO="PrintPOLink#xpath=(//li[@class='dropdown-submenu pull-left ng-scope'])[1]";
	    public static String ApprovePO_MyOrderTxt="MyOrderTxt#xpath=//div[contains(text(),'Orders to Approve')]";
	    
	    public static String ApprovePO_markAsReceive="markAsReceive#xpath=//a[text()='Mark as Receive Only']";
	    public static String ApprovePO_markAsReceiveNon="NonmarkAsReceive#xpath=//*[text()='Mark as Non Receive Only']";
	    public static String ApprovePO_changeDepartment="ApprovePO_changeDepartment#xpath=//*[@class='pull-right pagehead-normal']//*[@event='changeFacDept();']";	    
	    //public static String ApprovePO_ApproveButton="ApprovePO_ApproveButton#xpath=//*[@class='pull-right pagehead-normal']//*[@event='orderStatusFn('approve');']";
	   // public static String ApprovePO_RejectButton="ApprovePO_RejectButton#xpath=//*[@class='pull-right pagehead-normal']//*[@event='rejectOrder();']";
	    public static String ApprovePO_ApproveButton="partialButtonText#xpath=(//button[@id='btnAdd'])[6]//span";
		public static String ApprovePO_RejectButton="completeButton#xpath=(//button[@id='btnAdd'])[7]//span";
		
		public static String ApprovePO_selectDefaultUser="selectDefaultUser#xpath=//*[@id='facility']//span[@class='ng-binding ng-scope']";
		public static String ApprovePO_facilityDropdown="facilityDropdown#xpath=//*[@id='facility']";
		
		public static String ApprovePO_selectCreater="selectCreater#xpath=//*[@id='creater']//span[@class='ng-binding ng-scope']";
		public static String ApprovePO_UsersDropdown="UsersDropdown#xpath=//*[@name='creater']";
		public static String ApprovePO_POAuditLog="POAuditLog#xpath=//*[@class='pagehead ng-binding']";
		public static String ApprovePO_PrintItems="PrintItems#xpath=//a[@ng-click='downloadPdf(order);']";
		public static String ApprovePO_PrintItemsText="PrintItemsText#xpath=//*[@class='headtext']/span";
		public static String ApprovePO_Approve ="Approve#xpath=//*[@class='dropdown-submenu pull-left ng-scope'][1]//*[@class='dropdown-menu']//a[1])";
		public static String ApprovePO_RejectPOText ="RejectPOText#xpath=(//*[@class='dropdown-submenu pull-left ng-scope']//i[@class='fa fa-times'])[1]";
	    public static String ApprovePO_changeDepartmentText="ApprovePO_changeDepartmentText#xpath=//*[@class='dragDropList']/div";
	    public static String ApprovePO_POHeader="ApprovePO_POHeader#xpath=//*[@class='pagehead ng-binding']";
	    public static String ApprovePO_Approval="ApprovePO_Approval#xpath=//*[@class='dropdown-menu'][1]//li[1]//a[text()='Approval']";
	    public static String ApprovePO_approve ="approve#xpath=(//*[text()='Approval'])[1]";

	    
	    // Alert page 
	    public static String User_alert_preference_warning = "preference_warning#xpath=//*[@for='preference_warning']";
	    public static String User_alert_already_in_PO = "already_in_PO#xpath=//*[@for='already_in_PO']";
	    public static String User_alert_backorder_warning = "backorder_warning#xpath=//*[@for='backorder_warning']";
	    public static String User_alert_discount_warning = "discount_warning#xpath=(//*[@for='discount_warning'])[1]";
	    public static String User_alert_discount_contact_warning = "discount_contact_warning#xpath=(//*[@for='discount_warning'])[2]";
	    public static String User_alert_sucessmessage = "sucessmessage#xpath=//*[@class='toast-message' and text()='Profile updated successfully']";
	    // common
	    
	    
	    public static String No_Item_Found="NoItem#xpath=//*[text()='No Item Found']";
	    public static String HeaderClose="HeaderClose#xpath=//*[@class='headtext']//*[@class='close']";
	    public static String HeaderClose1="HeaderClose#xpath=(//*[@class='headtext']//*[@class='close'])[1]";
	    
	    
	    // Facility Module
	    public static String Facilities_Name="Name#xpath=//*[contains(text(),'Name')]";
	    public static String Facilities_Shipping_address="Shipping_address#xpath=//*[contains(text(),'Shipping address')]";
	    public static String Facilities_Invoice_address="Invoice_address#xpath=//*[contains(text(),'Invoice  address')]";
	    public static String Facilities_Edit_First="Edit#xpath=(//*[@uib-tooltip='Edit']//i)[1]";
	    public static String Facilities_Plus_First="Plusicon#xpath=(//button[@ng-if='!adminFacilitiesData.expanded'])[1]";
	    public static String Facilities_FacilityHeader="FacilityHeader#xpath=//*[@class='facility_department_header']";
	    public static String Facilities_Add_Btn_Facility="Add_Btn_Facility#xpath=//button[@ng-click='createFacility()']";
	    public static String Facilities_Save="Facilities_Save#xpath=//*[@name='facility']//button[text()='Save']";
	    public static String Facility_Search="Search#xpath=//*[@id='search-search']";
	    public static String Facility_Edit="Edit#xpath=//*[@class='headtext']//*[contains(text(),'Edit Facility')]";
	    
	    // Departments 
	    public static String Department_Search="Search#xpath=//*[@id='search-search']";
	    public static String Department_Facility="Facility#xpath=//*[@name='facility']";
	    public static String Department_AddDeptBtn="AddDeptBtn#xpath=//button[@ng-click='createDepartment()']";
	    
	    
	    // Physicians 
	    public static String Physicians_searchBy="SearchBy#xpath=//label[@for='search']";
	    public static String Physicians_Name="Name#xpath=//a[contains(text(),'Name')]";
	    public static String Physicians_NPINumber="NPINumber#xpath=//*[contains(text(),'NPI Number')]";
	    public static String Physicians_Facilities="Facilities#xpath=//th[contains(text(),'Facilities')]";
	    public static String Physicians_Delete_first="Delete_first#xpath=(//*[@title='Delete Physician'])[1]";
	    public static String Physicians_Edit_first="Edit_first#xpath=(//*[@title='Edit Physician'])[1]";
	    public static String Physicians_Addbtn="Addbtn#xpath=//button[text()='Add Physician']";
	    public static String Physicians_CreatePhysicianTitle="CreatePhysicianTitle#xpath=//*[contains(text(),'Create Physician')]";
	    public static String Physicians_FirstName="FirstName#xpath=//*[@id='first_name']";
	    public static String Physicians_Label_FirstName="LabelFirstName#xpath=//*[contains(text(),'First Name')]";
	    public static String Physicians_last_name="last_name#xpath=//*[@id='last_name']";
	    public static String Physicians_Label_last_name="last_name#xpath=//*[contains(text(),'Last Name')]";
	    public static String Physicians_mrn_number="mrn_number#xpath=//*[@id='mrn_number']";
	    public static String Physicians_Label_mrn_number="label_mrn_number#xpath=//*[contains(text(),'NPI Number')]";
	    public static String Physicians_Facility_ItemList="Facility_ItemList#xpath=//*[@class='item-menu-action']";
	    public static String Physicians_Label_Facility="LabelFacility#xpath=//*[contains(text(),'Facilities*')]";
	    public static String Physicians_InputFacility="InputFacility#xpath=//*[@id='itemslist']";
	    public static String Physicians_Edit="Edit#xpath=(//*[@title='Edit Physician'])[1]";
	    public static String Physicians_EditTitle="EditTitle#xpath=//*[contains(text(),'Edit Physician')]";
	    public static String Physicians_Delete="Delete#xpath=(//*[@title='Delete Physician'])[1]";

	    // Item catalog
	    public static String Itemcatalog_btn_AddItem="btn_AddItem#xpath=//button[text()='Add Item']";
	    public static String Itemcatalog_SearchBy="SearchBy#xpath=//label[text()='Search by:']";
	    public static String Itemcatalog_label_vendorName="vendorName#xpath=//label[text()='Vendor Name:']";
	    public static String Itemcatalog_label_Status="Status#xpath=//label[text()='Status:']";
	    public static String Itemcatalog_label_Type="Type#xpath=//label[text()='Type:']";
	    public static String Itemcatalog_input_Type="input_Type#xpath=//select[@id='type']";
	    public static String Itemcatalog_label_Category="Category#xpath=//label[text()='Category:']";
	    public static String Itemcatalog_input_category="input_category#xpath=//select[@id='category']";
	    public static String Itemcatalog_Noitemfound="Noitemfound#xpath=//*[contains(text(),'No item found.')]";
	    
	    
	    // Item Categories
	    public static String ItemcaCategory_btn_AddCategory="AddCategory#xpath=//*[text()='Add Category']";
	    public static String ItemcaCategory_SearchCategoryBy="SearchCategory#xpath=//label[text()='Search Category By']";
	    public static String ItemcaCategory_CreateCategory="CreateCategory#xpath=//*[text()='Create Category']";
	    public static String ItemcaCategory_EditCategory="EditCategory#xpath=//*[contains(text(),'Edit Category')]";
	    public static String ItemcaCategory_CreateCategory_Input_Name="InputName#xpath=//*[@id='name']";
	    public static String ItemcaCategory_CreateCategory_Label_Name="LabelName#xpath=//*[text()='Name ']";
	    public static String ItemcaCategory_CreateCategory_btn_Save="btn_Save#xpath=//button[text()='Save']";
	    public static String ItemcaCategory_CreateCategory_btn_Close="btn_Close#xpath=//button[text()='Close']";
	    public static String ItemcaCategory_EditCategory_Input_Search="Input_Search#xpath=//*[@id='search']";
	    public static String ItemcaCategory_btn_Search="btn_Search#xpath=//button[text()='Search']";
	    public static String ItemcaCategory_Delete="Delete#xpath=//button[text()='Delete']";
	    public static String ItemcaCategory_Edit="Edit#xpath=//button[text()='Edit']";	    
	    
	    public static String ItemcaCategory_ManageFacilityUpdateprive="ManageFacilityUpdateprive#xpath=(//*[@ng-click='manageItemVendorFacility(vendor)'])[1]";
	    
	    
	    
	     // admin Barcode
	     // admin Barcode
	    public static String Barcode_Facility="SeletFacility#xpath=//*[@select-list='facilities']";
	    public static String Barcode_Facility_Header="Header#xpath=//*[text()='Select Facility']";
	    public static String Barcode_SearchItemByTxt="SearchItemBy#xpath=//*[text()='Search Item By']";
	    public static String Barcode_ItemNameTxt="ItemName#xpath=//*[contains(text(),'Item Name')]";
	    public static String Barcode_VendorTxt="Vendor#xpath=//*[contains(text(),'Vendor')]";
	    public static String Barcode_SKUTxt="SKU#xpath=//*[contains(text(),'SKU')]";
	    public static String Barcode_UOMTxt="UOM#xpath=//*[contains(text(),'UOM')]";
	    public static String Barcode_StatusTxt=" Status #xpath=//*[contains(text(),'Status')]";
	    public static String Barcode_PriceTxt="Price#xpath=//*[contains(text(),'Price')]";
	    
	    
	    // Vendor
	    public static String Vendor_Title ="Header#xpath=//*[contains(text(),'Manage Vendors')]";
	    public static String Vendor_EditFirst ="Edit#xpath=(//button[text()='Edit'])[1]";
	    public static String Vendor_InternalCode ="InternalCode#xpath=//*[text()='Internal code:']";
	    public static String Vendor_txt ="Vendor#xpath=//a[text()='Vendor']";
	    public static String Vendor_Address ="Address#xpath=//a[text()='Address']";
	    public static String Vendor_Interface ="Interface#xpath=//a[text()='Interface']";
	    public static String Vendor_UOM ="UOM#xpath=//a[text()='UOM']";
	    public static String Vendor_Customersupport ="Customersupport#xpath=//a[text()='Customer Support']";
	    public static String Vendor_SalesRepresentative ="SalesRepresentative#xpath=//a[text()='Sales Representative']";
	    public static String Vendor_UOM_UOM1 ="UOM1#xpath=//*[text()='UOM 1']";
	    public static String Vendor_Customersupport_Name ="Name#xpath=(//*[@id='reqListing']//*[contains(text(),'Name')])[1]";
	    public static String Vendor_Customersupport_Email ="Email#xpath=(//*[@id='reqListing']//*[contains(text(),'Email')])[1]";
	    public static String Vendor_Customersupport_Phone ="Phone#xpath=(//*[@id='reqListing']//*[contains(text(),'Phone')])[1]";
	    public static String Vendor_Customersupport_Addbtn ="Addbtn#xpath=(//*[@class='tab-pane ng-scope active']//button[text()='Add'])";
	    public static String Vendor_Customersupport_Header ="Header#xpath=//*[text()='Add Customer Support Info']";
	    public static String Vendor_Customersupport_Custom_Name ="Name#xpath=(//*[text()='Name*'])[1]";
	    public static String Vendor_Customersupport_Custom_Email ="Email#xpath=(//*[text()='Email*'])[1]";
	    public static String Vendor_Customersupport_Custom_Phone ="Phone#xpath=(//*[text()='Phone*'])[1]";
	    public static String Vendor_Customersupport_Custom_Name_input ="Name#xpath=(//*[@id='name'])[1]";
	    public static String Vendor_Customersupport_Custom_Email_input ="Email#xpath=//*[@id='email']";
	    public static String Vendor_Customersupport_Custom_Phone_input ="Phone#xpath=//*[@id='phone']";
	    public static String Vendor_Customersupport_Custom_NameValidation ="NameValidation#xpath=//*[text()='Name cannot be blank.']";
	    public static String Vendor_Customersupport_Custom_EmailValidation ="EmailValidation#xpath=//*[text()='Email is not a valid email address.']";
	    public static String Vendor_Customersupport_Custom_PhoneValidation ="PhoneValidation#xpath=//*[text()='Phone cannot be blank.']";
	    public static String Vendor_Customersupport_Custom_Close ="Close#xpath=(//button[text()='Close'])[1]";
	    public static String Vendor_Customersupport_Custom_Deletevalidation ="Deletevalidation#xpath=//*[text()='Are you sure you want to delete selected vendor information?']";
	    public static String Vendor_Sales_Name ="Name#xpath=(//*[@class='tab-pane ng-scope active']//*[contains(text(),'Name')])";
	    public static String Vendor_Sales_Email ="Email#xpath=(//*[@class='tab-pane ng-scope active']//*[contains(text(),'Email')])";
	    public static String Vendor_Sales_Phone ="Phone#xpath=(//*[@class='tab-pane ng-scope active']//*[contains(text(),'Phone')])";
	    public static String Vendor_Sales_Addbtn ="Addbtn#xpath=(//*[@class='tab-pane ng-scope active']//button[text()='Add'])";
	    public static String Vendor_Sales_Header ="Header#xpath=//*[text()='Add Sales Representative Info']";
	    public static String Vendor_Sales_Input_Name ="Name#xpath=(//*[text()='Name*'])[2]";
	    public static String Vendor_Sales_Input_Email ="Email#xpath=(//*[text()='Email*'])[2]";
	    public static String Vendor_Sales_Input_Phone ="Phone#xpath=(//*[text()='Phone*'])[2]";
	    public static String Vendor_Sales_Close ="Close#xpath=(//button[text()='Close'])[1]";
	    public static String Vendor_Edit_Sales_Header ="Header#xpath=//*[text()='Edit Sales Representative Info']";
	    public static String Vendor_Edit_Sale ="Edit#xpath=(//*[@class='tab-pane ng-scope active']//tbody//i[@class='fa fa-edit'])";
	    public static String Vendor_Delete_Sale ="Delete#xpath=(//*[@class='tab-pane ng-scope active']//tbody//i[@class='fa fa-trash'])";
	    public static String Vendor_Sales_Savebtn = "Savebtn#xpath=(//button[text()='Save'])[1]";		
	    public static String Vendor_Edit_NameLabel ="NameLabel#xpath=//*[text()='Name*']";
	    public static String Vendor_Edit_SecondName_Label ="SecondNameLabel#xpath=//*[text()='Second Name']";
	    public static String Vendor_Edit_ThirdName_Label ="ThirdName_Label#xpath=//*[text()='Third Name']";
	    public static String Vendor_Edit_SupportCutoffLabel ="SupportCutoff#xpath=//*[text()='Support Cut Off Time']";
	    public static String Vendor_Edit_Logo_Label ="Logo#xpath=//*[text()='Logo']";
	    public static String Vendor_Edit_ConsignmentSupport_Label ="ConsignmentSupport#xpath=//*[text()='Is Consignment Supported']";
	    public static String Vendor_Edit_LimitSupport_Label ="LimitSupport#xpath=//*[text()='Is PO Amount Limit Supported']";
	    public static String Vendor_Edit_MinPOAmount_Label ="MinPOAmount#xpath=//*[text()='Minimum PO Amount*']";
	    public static String Vendor_Edit_PriceUpdate855_Label ="PriceUpdate855#xpath=//*[text()='Is price update from 855']";
	    public static String Vendor_Edit_PriceUpdate810_Label ="PriceUpdate810#xpath=//*[text()='Is price update from 810']";
	    public static String Vendor_Edit_Payment_Term_Label ="Payment_Term#xpath=//*[text()='Payment Term']";
	    public static String Vendor_Edit_Payment_Term_Input ="Payment_Term#name=payment_term";
	    public static String Vendor_Edit_Status_Label ="Status#xpath=//*[text()='Status']";
	    public static String Vendor_Edit_SecondName_Input ="SecondName_Input#xpath=//*[@id='secondary_name']";
	    public static String Vendor_Edit_third_name_Input ="third_name_Input#xpath=//*[@id='third_name']";
	    public static String Vendor_Edit_PunchOutOn ="PunchOutOn#xpath=//*[text()='Is Support Punch out']/following-sibling::div/div";
	    public static String Vendor_Edit_Priceupdate855 ="Priceupdate855#xpath=//*[text()='Is price update from 855']/following-sibling::div/div";
	    public static String Vendor_Edit_Priceupdate810 ="Priceupdate810#xpath=//*[text()='Is price update from 810']/following-sibling::div/div";
	    public static String Vendor_Edit_StatusInput ="Status#xpath=//*[text()='Status']/following-sibling::div/div";
	    public static String Vendor_ConfirmationLeaving ="ConfirmationLeaving#xpath=//*[text()='You have some unsaved changes, do you want to save them before leaving the page?']";
	   
	    public static String Vendor_Address_Addressline1 ="Addressline1#xpath=//*[text()='Address Line 1']";
	    public static String Vendor_Address_Addressline2 ="Addressline2#xpath=//*[text()='Address Line 2']";
	    public static String Vendor_Address_City ="City#xpath=//*[text()='City']";
	    public static String Vendor_Address_County ="County#xpath=//*[text()='County']";
	    public static String Vendor_Address_State ="State#xpath=//*[text()='State']";
	    public static String Vendor_Address_PostalCode ="Postal_Code#xpath=//*[text()='Postal Code']";
	    public static String Vendor_Address_Country ="Country#xpath=//*[text()='Country']";
	    public static String Vendor_Address_Phone1 ="Phone1#xpath=//*[text()='Phone 1']";
	    public static String Vendor_Address_Phone2 ="Phone2#xpath=//*[text()='Phone 2']";
	    public static String Vendor_Address_Fax1 ="Fax1#xpath=//*[text()='Fax 1']";
	    public static String Vendor_Address_Fax2 ="Fax2#xpath=//*[text()='Fax 2']";
	    public static String Vendor_Address_Email1 ="Email1#xpath=//*[text()='Email 1']";
	    public static String Vendor_Address_Email2 ="Email2#xpath=//*[text()='Email 2']";
	    
	    public static String Vendor_Interface_Internalcode ="Internalcode#xpath=//*[text()='Internal Code']";
	    public static String Vendor_Interface_Input_Internalcode ="InputInternalcode#xpath=//*[@id='id']";
	    public static String Vendor_Interface_InterfaceType ="InterfaceType#xpath=//*[text()='Interface Type']";
	    public static String Vendor_Interface_Sendpo ="Sendpo#xpath=//*[text()='Send PO email/efax at']";
	    public static String Vendor_Interface_SendpoUpdate ="SendpoUpdate#xpath=//*[text()='Send PO updates to']";
	    public static String Vendor_Interface_SendpoUpdate1Des ="SendpoUpdate1#xpath=(//*[@id='helpBlock'])[1]";
	    public static String Vendor_Interface_SendpoUpdate2Des ="SendpoUpdate2#xpath=(//*[@id='helpBlock'])[2]";
	    
	    // Vendor Account Setup
	 	public static String VendorAccSetup_Pagetitle ="Pagetitle#xpath=//a[text()='Vendors Account Setup']";
	 	public static String VendorAccSetup_SelctVendor ="SelctVendor#xpath=//*[contains(text(),'Select Vendors')]";
	 	public static String VendorAccSetup_VendorDropdown ="VendorDropdown#xpath=//*[@id='vendor_dropdown']";
	 	public static String VendorAccSetup_AccountNumber_First ="AccountNumber#xpath=(//*[text()='Account Number*']/following-sibling::div/input)[1]";
	 	public static String VendorAccSetup_AccountNumber_Radiobtn1 ="Radiobtn1#xpath=(//*[@type='radio'])[1]";
	 	public static String VendorAccSetup_AccountNumber_RadioBtn2 ="Radiobtn2#xpath=(//*[@type='radio'])[2]";
	 	public static String VendorAccSetup_VendorName ="VendorNamae#xpath=//*[@class='vendor-acc-header ng-binding']";
	 	public static String VendorAccSetup_Save ="Save#xpath=//button[text()='Save']";
	 	public static String VendorAccSetup_Close ="Close#xpath=//button[text()='Close']";
	 	public static String VendorAccSetup_DepartmentWise ="DepartmentWise#xpath=(//*[text()='Department Wise'])[1]";
	 	public static String VendorAccSetup_Departments ="Departments#xpath=(//*[text()='Departments'])[1]";
	 	public static String VendorAccSetup_AccountNumber ="AccountNumber#xpath=(//*[text()='Account Number'])[1]";
	 	public static String VendorAccSetup_Validation ="Validation#xpath=(//*[text()='Account number should be greater than or equal to 2 characters.'])[1]";
	 	public static String VendorAccSetup_FacilityName ="FacilityName#xpath=(//*[@class='vendor-acc-content-inner-head ng-binding'])[1]";
	 	
	 	// Price Tire
	 	public static String PriceTire_PageTitle ="PageTitle#xpath=//*[contains(text(),'MANAGE PRICE TIER')]";
	 	public static String PriceTire_BtnVendorPrice ="BtnVendorPrice#xpath=//button[text()='Vendor Price Tier Setup']";
	 	public static String PriceTire_btnAdd ="btnAdd#xpath=//button[text()='Add']";
	 	public static String PriceTire_SearchBox ="Searchbox#xpath=//*[@id='search-search']";
	 	public static String PriceTire_SearchTxt ="SearchTxt#xpath=//label[contains(text(),'Search')]";
	 	public static String PriceTire_txt_Name ="Name#xpath=//a[contains(text(),'Name')]";
	 	public static String PriceTire_txt_Pricepercentage ="Pricepercentage#xpath=//a[contains(text(),'Price percentage')]";
	 	public static String PriceTire_AddBtn ="AddBtn#xpath=//button[text()='Add']";
	 	public static String PriceTire_Add_AddPriceTire ="txt_AddPriceTire#xpath=//*[contains(text(),'Add Price Tier')]";
	 	public static String PriceTire_Add_Nametxt ="txt_Name#xpath=//label[text()='Name*']";
	 	public static String PriceTire_Add_Name_Input ="input_Name#xpath=//*[@id='tiername']";
	 	public static String PriceTire_Add_Healpdesk ="Healpdesk#xpath=//*[@id='helpBlock']";
	 	public static String PriceTire_Add_PricePercentagetxt ="txt_PricePercentage#xpath=//label[text()='Price Percentage*']";
	 	public static String PriceTire_Add_price_percentage_Input ="price_percentage#xpath=//*[@id='price_percentage']";
	 	public static String PriceTire_Add_Save ="Save#xpath=//button[text()='Save']";
	 	public static String PriceTire_Delete_cancel ="Delete_cancel#xpath=//button[text()='Cancel']";
	 	public static String PriceTire_Delete_Yes ="Delete_Yes#xpath=//button[text()='Yes']";
	 	public static String PriceTire_Add_Close ="Close#xpath=//button[text()='Close']";
	 	public static String PriceTire_EditPrice ="Edit#xpath=//i[@class='fa fa-edit']";
	 	public static String PriceTire_EditPrice_Pagetitle ="EditPrice_Pagetitle#xpath=//*[contains(text(),'Edit Price Tier')]";
	 	public static String PriceTire_Delete ="Deletebtn#xpath=//i[@class='fa fa-trash']";
	 	public static String PriceTire_DeleteValidation ="DeleteValidation#xpath=//h2/following-sibling::p";
	 	public static String PriceTire_VendorPrice_Title ="VendorPrice_Title#xpath=//*[@class='headtext']//*[text()='Vendor Price Tier Setup']";
	 	
	 	// Display Priority
	 	public static String DisplayPriority_Title ="Title#xpath=//*[contains(text(),'Manage Vendor Display Priority')]";
	 	public static String DisplayPriority_SaveBtn ="SaveBtn#xpath=//button[contains(text(),'Save')]";
	 	public static String DisplayPriority_DragInfo ="DragInfo#xpath=//strong";
	 	
	 	// PO Special Instruction
	 	public static String PoSpecialInst_Add ="Addbtn#xpath=//*[@ng-click='createSpecialInstructions()']";
	 	public static String PoSpecialInst_SearchInput ="Search#xpath=//*[@id='search-search']";
	 	public static String PoSpecialInst_SearchBtn ="Searchbtn#xpath=//button[text()='Search']";
	 	public static String PoSpecialInst_AddPageTitle ="AddPageTitle#xpath=//*[contains(text(),'Add PO Special Instructions')]";
	 	public static String PoSpecialInst_Add_SpecialInstruction ="SpecialInstruction#xpath=//*[contains(text(),'Special Instructions*')]";
	 	public static String PoSpecialInst_Add_Save ="Save#xpath=(//button[text()='Save'])[1]";
	 	public static String PoSpecialInst_Add_Close ="Close#xpath=(//button[text()='Close'])[1]";
	 	public static String PoSpecialInst_Add_InputName ="InputName#xpath=//*[@id='name']";
	 	public static String PoSpecialInst_Searchvalidation ="SearchValidation#xpath=//*[text()='No data available in table']";
	 	public static String PoSpecialInst_Edit_SpecialInstruction ="SpecialInstruction#xpath=//*[contains(text(),'Special instruction')]";
	 	public static String PoSpecialInst_EditIcon ="EditIcon#xpath=(//*[@class='fa fa-edit'])[1]";
	 	public static String PoSpecialInst_DeleteIcon ="DeleteIcon#xpath=(//*[@class='fa fa-trash'])[1]";
	 	public static String PoSpecialInst_Deletevalidation ="Deletevalidation#xpath=//*[text()='Are you sure you want to delete this Special instruction ?']";
	 	
	 	// Manage Invoice Payment Terms
	 	public static String InvoicePaymentTerm_Title ="Title#xpath=//*[contains(text(),'Manage Invoice Payment Terms')]";
	 	public static String InvoicePaymentTerm_SearchBox="SearchBox#xpath=//*[@id='search-search']";
	 	public static String InvoicePaymentTerm_Descriptiontxt="Description#xpath=//*[contains(text(),'Description')]";
	 	public static String InvoicePaymentTerm_Typetxt="Type#xpath=//*[contains(text(),'Type')]";
	 	public static String InvoicePaymentTerm_NoOfDaystxt="NoOfDays#xpath=//*[contains(text(),'No of Days')]";
	 	public static String InvoicePaymentTerm_Discounttxt="Discount#xpath=//*[contains(text(),'Discount/Penalty (%)')]";
	 	public static String InvoicePaymentTerm_AddPayment_Btn="AddPaymentBtn#xpath=//button[text()='Add Payment Term']";
	 	public static String InvoicePaymentTerm_AddPayment_Header="Header#xpath=//*[@class='headtext']//*[text()='Add Payment Term']";
	 	public static String InvoicePaymentTerm_AddPayment_Description_Label="Description_Label#xpath=//*[text()='Description :']";
	 	public static String InvoicePaymentTerm_AddPayment_Type_Label="Type_Label#xpath=//*[text()='Type :']";
	 	public static String InvoicePaymentTerm_AddPayment_Day_Label="Day_Label#xpath=//*[text()='Day(s) :']";
	 	public static String InvoicePaymentTerm_AddPayment_Day_Input="Day#xpath=//*[@id='paymentTermDays']";
	 	public static String InvoicePaymentTerm_AddPayment_Percent_Label="Percent_Label#xpath=//*[text()='Percent (%) :']";
	 	public static String InvoicePaymentTerm_AddPayment_Percent="Percent#xpath=//*[@id='paymentTermPercent']";
	 	public static String InvoicePaymentTerm_AddPayment_APIntegratiot_Label="APIntegratiot_Label#xpath=//*[text()='AP Integration ID :']";
	 	public static String InvoicePaymentTerm_AddPayment_APIntegratiot="APIntegratiot#xpath=//*[@id='ApIntegrationId']";
	 	public static String InvoicePaymentTerm_AddPayment_paymentTermType_Selectdropdown="paymentTermType#xpath=//*[@id='paymentTermType']";
	 	public static String InvoicePaymentTerm_AddPayment_addButtton="addButtton#xpath=//button[text()='Add']";
	 	public static String InvoicePaymentTerm_AddPayment_CancelButtton="CancelButtton#xpath=//*[@class='modal-footer']//button[text()='Cancel']";
	 	public static String InvoicePaymentTerm_Editicon="Edit#xpath=(//i[@class='fa fa-edit'])[1]";
	 	public static String InvoicePaymentTerm_Deleteicon="Delete#xpath=(//i[@class='fa fa-trash-o'])[1]";
	 	public static String InvoicePaymentTerm_Edit_Header="Header#xpath=//*[text()='Update Payment Term']";
	 	public static String InvoicePaymentTerm_Edit_Update="Update#xpath=(//button[text()='Update'])[1]";
	 	public static String InvoicePaymentTerm_Delete_sucess="DeleteSucess#xpath=//*[text()='Payment Term deleted successfully.']";
	 	public static String InvoicePaymentTerm_Delete_Ok="DeleteOk#xpath=//button[text()='Ok']";
	 	
	 	// Pattern
	 	public static String Pattern_Name_txt="Name_txt#xpath=(//*[contains(text(),'Name')])[1]";
	 	public static String Pattern_Template_txt="Template_txt#xpath=//*[contains(text(),'Template')]";
	 	public static String Pattern_CurrentValue_txt="CurrentValue#xpath=//*[contains(text(),'Current Value')]";
	 	public static String Pattern_Edit="Edit#xpath=(//a[@uib-tooltip='Edit'])[1]";
	 	public static String Pattern_Delete="Delete#xpath=(//a[@uib-tooltip='Delete'])[1]";
	 	public static String Pattern_AddBtn="AddBtn#xpath=//button[contains(text(),'Add')]";
	 	public static String Pattern_Add_AddPttern_txt="AddPttern#xpath=//*[contains(text(),'Add Pattern')]";
	 	public static String Pattern_Add_labelName ="labelName#xpath=//label[text()='Name*']";
	 	public static String Pattern_Add_Name ="Name#xpath=//*[@id='name']";
	 	public static String Pattern_Add_label_SelectTemplate ="labelSelectTemplate#xpath=//label[text()='Select Template*']";
	 	public static String Pattern_Add_SelectTeamplate ="SelectTeamplate#xpath=//*[@id='sel_template']";
	 	public static String Pattern_Add_label_Template ="labelTemplate#xpath=//label[text()='Template']";
	 	public static String Pattern_Add_label_Initialvalue ="labelInitialvalue#xpath=//label[text()='Initial Value']";
	 	public static String Pattern_Add_AddTemplatebtn ="AddTemplatebtn#xpath=//*[@id='btn_add_template']";
	 	public static String Pattern_Add_InitialValue ="InitialValue#xpath=//*[@name='tpl_initial_value']";
	 	public static String Pattern_Add_Save ="Save#xpath=//button[text()='Save']";
	 	public static String Pattern_Add_Close ="Close#xpath=//button[text()='Close']";
	 	public static String Pattern_Deletevalidation ="Deletevalidation#xpath=//*[text()='Are you sure you want to delete this Pattern ?']";
	 	
	 	// Approval flow
	 	public static String ApprovalFlow_label_Facility ="LabelFacility#xpath=//label[contains(text(),'Facility')]";
	 	public static String ApprovalFlow_search ="search#xpath=//*[@id='search-search']";
	 	public static String ApprovalFlow_searchBtn ="searchBtn#xpath=//button[text()='Search']";
	 	public static String ApprovalFlow_Searchvalidation ="SearchValidation#xpath=//*[text()='No data available in table']";
	 	public static String ApprovalFlow_First_Name ="Name#xpath=//*[@id='reqListing']/tbody/tr[1]/td[1]";
	 	public static String ApprovalFlow_First_Facilitycount ="Facilitycount#xpath=//*[starts-with(@href,'#/approvals/flow/')]/preceding-sibling::span";
	 	public static String ApprovalFlow_First_ManageFlow ="ManageFlow#xpath=(//*[starts-with(@href,'#/approvals/flow/')])[1]";
	 	public static String ApprovalFlow_First_ManageFacility ="ManageFacility#xpath=(//a[contains(text(),'Manage Facilities')])[1]";
	 	public static String ApprovalFlow_First_DeleteIcon ="DeleteIcon#xpath=(//*[@class='fa fa-trash'])[1]";
	 	public static String ApprovalFlow_First_Deletecancel ="Deletecancel#xpath=//button[text()='Cancel']";
	 	public static String ApprovalFlow_Addbtn ="Addbtn#xpath=//button[contains(text(),'Add')]";
	 	public static String ApprovalFlow_Refreshbtn ="Refreshbtn#xpath=//button[contains(text(),'Refresh')]";
	 	public static String ApprovalFlow_Add_Title ="Add_Title#xpath=//*[text()='Add Template']";
	 	public static String Approvalflow_txt_Name ="labelName#xpath=//label[text()='Name*']";
	 	public static String Approvalflow_txt_Facilities ="labelFacilities#xpath=//label[contains(text(),'Facilities*')]";
	 	public static String Approvalflow_Input_Name ="InputName#xpath=//*[@id='name']";
	 	public static String Approvalflow_Input_Facilities ="inputFacilities#xpath=//*[@id='itemslist']";
	 	public static String Approvalflow_Click_Facilities ="inputFacilities#xpath=//*[@for='itemslist']";
	 	public static String Approvalflow_SelectFacility ="SelectFacility#xpath=//*[@class='glyphicon glyphicon-plus autocomplete-show']";
	 	public static String Approvalflow_Add_Save ="Save#xpath=//button[text()='Save']";
	 	public static String Approvalflow_Add_Close ="Close#xpath=//button[text()='Close']";
	 	public static String Approvalflow_Add_Minux ="minus#xpath=//*[@class='glyphicon glyphicon-minus autocomplete-show']";
	 	public static String Approvalflow_Add_croxxx ="crox#xpath=//*[@class='fa fa-times']";
	 	public static String Approvalflow_Add_Downbtn ="Downbtn#xpath=(//*[@id='btn-append-to-single-button'])[1]";
	 	public static String Approvalflow_MangeFlow_AddLevel ="AddLevel#xpath=//button[text()='Add Level']";	
	 	public static String Approvalflow_MangeFlow_AddRule ="AddRule#xpath=(//body/ul/li//*[text()='Add Rule'])[1]";
	 	public static String Approvalflow_MangeFlow_EditRule ="EditRule#xpath=html/body/ul/li//*[text()='Edit Rule']";
	 	public static String Approvalflow_MangeFlow_DeleteRule ="DeleteRule#xpath=html/body/ul/li//*[text()='Delete Rule']";
	 	public static String Approvalflow_MangeFlow_DeleteRule_validation ="Validation#xpath=//*[text()='Are you sure you want to delete this level rule ?']";
	 	public static String Approvalflow_MangeFlow_AddRule_Cutofflabel ="Cutofflabel#xpath=//*[text()='Cut off time(Hrs)*']";
	 	public static String Approvalflow_MangeFlow_AddRule_Cutofftime ="Cutofftime#xpath=//*[@id='cut_off_time']";
	 	public static String Approvalflow_MangeFlow_AddRule_Cutofftime_validation ="valiadtion#xpath=//*[text()='Cut off time must be number in hrs, Ex: 19.00.']";
	 	public static String Approvalflow_MangeFlow_AddRule_poAmountlimit_validation ="valiadtion#xpath=//*[text()='Please provide valid PO amount limit for this level, , Ex: 100.00.']";
	 	public static String Approvalflow_MangeFlow_AddRule_poAmountlimit ="poAmountlimit#xpath=//*[@id='po_amount_limit']";
	 	public static String Approvalflow_MangeFlow_AddRule_poAmountlimitlabel ="poAmountlimit#xpath=//*[text()='PO amount limit(USD)*']";
	 	public static String Approvalflow_MangeFlow_DeleteLevel ="DeleteLevel#xpath=//body/ul/li//a[text()='Delete Level']";
	 	public static String Approvalflow_MangeFlow_NoLevel ="NoLevel#xpath=//*[text()='No level is added to this template']";
	 	public static String Approvalflow_MangeFlow_AddLevel_LevelName ="LevelName#xpath=//label[text()='Level name*']";
	 	public static String Approvalflow_MangeFlow_AddLevel_InputLevelName ="LevelName#xpath=//*[@id='level_name']";
	 	public static String Approvalflow_MangeFlow_AddLevel_validation ="AtleastOne#xpath=//*[text()='Please add atleast one user to this level.']";
	 	public static String Approvalflow_MangeFlow_AddLevel_Header ="Header#xpath=//*[text()='Add Level User']";
	 	public static String Approvalflow_MangeFlow_AddLevel_Label_SelectUser ="Label_SelectUser#xpath=//label[text()='Select User']";
	 	public static String Approvalflow_MangeFlow_AddLevel_SelectUser ="SelectUser#xpath=//*[@id='user']";
	 	public static String Approvalflow_MangeFlow_AddLevel_SelectFacility ="SelectFaacility#xpath=//*[@id='facility-select']";
	 	public static String Approvalflow_MangeFlow_AddLevel_Close ="Close#xpath=//*[@class='headtext']//button[@class='close']";
	 	public static String Approvalflow_MangeFlow_AddLevel_Selectdepartment ="Selectdepartment#xpath=//*[@id='department-select']";
	 	public static String Approvalflow_MangeFlow_Deletelevel_validation ="validation#xpath=//*[text()='Are you sure you want to delete this level ?']";
	 	public static String Approvalflow_MangeFlow_AddLevel_Facility_spec ="SelectFac#xpath=//*[contains(text(),'Select Facilities')]/following-sibling::div//*[@class='item-menu-action']";
	 	public static String Approvalflow_MangeFlow_AddLevel_Facility_Select ="SelectFac#xpath=(//*[starts-with(@class,'vendor-list-item')]//*[starts-with(@class,'glyphicon')])[1]";
	 	public static String Approvalflow_MangeFlow_AddLevel_Dept_Select ="SelectDept#xpath=(//*[text()='Select Departments ']/following-sibling::div[2]//*[starts-with(@class,'glyphicon')])[1]";
	 	public static String Approvalflow_MangeFlow_AddLevel_Dept_spec ="SelectDept#xpath=//*[contains(text(),'Select Departments')]/following-sibling::div//*[@class='item-menu-action']";
	 	public static String Approvalflow_MangeFlow_AddLevel_AutoApproval ="AutoApproval#xpath=//*[@for='autoapprove']/following-sibling::div/div";
	 	public static String Approvalflow_MangeFlow_Edit ="Edit#xpath=(//*[@class='fa fa-edit'])[1]";
	 	public static String Approvalflow_Approve ="Approve#xpath=//*[@id='btnAdd' and contains(text(),'Approve')]";
	 	public static String Approvalflow_Reject ="Reject#xpath=//*[text()='Reject ']";
	 	public static String Approvalflow_Reject_validation ="Rejectvalidation#xpath=//*[text()='Are you sure? Do you want to reject this order?']";
	 	public static String Approvalflow_PrintItem_GeneratePO ="GeneratePO#xpath=//*[contains(text(),'Generate PDF')]";
	 	public static String Approvalflow_PrintItem_Barcode ="Barcode#xpath=//a[text()='Barcode']";
	 	public static String Approvalflow_PrintItem_QRCODE ="QRCODE#xpath=//a[text()='QR code']";
	 	
	 	// Common
	    public static String Pagination="Pagination#classname=pagination-first";
	    public static String Pagination_Last="PaginationLast#xpath=(//a[text()='Last'])[1]";
	    public static String Pagination_First="PaginationFirst#xpath=(//a[text()='First'])[1]";
	    public static String ProfileUpdate="ProfileUpdate#xpath=//*[text()='Profile update.']";
	    public static String ProfileUpdate_Logmeout ="Logmeout#xpath=//button[text()='Log me out']";
		public static String Pagination_ActivePage="PaginationActivePage#xpath=//li[@class='pagination-page ng-scope active']/a";
		public static String DD_Edit="Edit#xpath=//*[contains(@style ,'display: block;')]//*[text()='Edit']";
		public static String DD_PriceChangeHistory="PriceChangeHistory#xpath=//*[contains(@style ,'display: block;')]//*[text()='Price Change History']";
		public static String DD_PurchaseHistory="PurchaseHistory#xpath=//*[contains(@style ,'display: block;')]//*[text()='Purchase History']";



		}



