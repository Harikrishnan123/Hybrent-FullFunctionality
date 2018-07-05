package AutomationFramework;

public class _OR {
	
	// Login Page
	
	public static String Login_HybrentLogo="HybrentLogo#xpath=//img[@src='images/site-logos/hybrent-light.png']";
	public static String Login_ADFSlink="ADFSlink#xpath=//*[@class='adfslogin-link']/a[contains(text(),'Login with ADFS')]";
	public static String Login_link_LoginHybrent="LoginHybrent#xpath=//a[contains(text(),'Login with Hybrent')]";
	public static String Login_link_LoginADFS_Right="LoginADFS#xpath=//a[@class='pull-right' and contains(text(),'Login with ADFS')]";
	public static String Label_signinnewuser = "signinnewuser#xpath=//a[text()='Sign in with new user']";
	public static String Label_username = "Labelusername#xpath=//*[@for='userName']";
	public static String Label_password = "Labelpassword#xpath=//*[@for='password']";
	public static String Login_Username = "Input_UserName#Angular_Model=model.userName";
	public static String Login_Password = "Input_Password#Angular_Model=model.password";
	public static String Login_Submit = "LoginBtn#xpath=//*[@type='submit']";
	public static String Login_Error = "Error#xpath=//h2[contains(text(),'Error?')]";
	public static String Login_Validation = "ErrorValidation#xpath=//*[contains(text(),'Invalid user name or password.')]";
	public static String Login_okay = "Errorok#xpath=//*[@class='confirm']";
	public static String Login_copyRight = "CopyRight#xpath=//copyright";
	public static String Login_version = "buildVersion#xpath=//build-version";
	public static String Login_Logout = "logOut#xpath=//a[@ng-click='logout()']";
	public static String Loginusername = "Loginusername#xpath=//p[@class='user-label']";
	public static String LoginuserEmail = "LoginEmail#xpath=//p[@class='user-email']";
	public static String LoginuserStatus = "LoginStatus#xpath=//p[@class='user-status']";
	
	// Dashboard - admin
	public static String DashBoard_Admin = "Admin#xpath=//admin-menu/a";
	public static String DashBoard_Admin_organization = "organization#xpath=//a[@href='#/admin/organization']";
	public static String DashBoard_Admin_organization_Features = "organizationFeatures#xpath=//a[text()='Features']";
	public static String DashBoard_Admin_organization_Features_adfs_auth = "adfs_auth#xpath=//*[@for='adfs_auth']";
	public static String DashBoard_Admin_organizationbudget = "organization-budget#xpath=//a[@href='#/admin/organization-budget']";
	public static String DashBoard_Admin_facility = "facility#xpath=//a[@href='#/admin/facility']";
	public static String DashBoard_Admin_department = "department#xpath=//a[@href='#/admin/department']";
	public static String DashBoard_Admin_physicians = "physicians#xpath=//a[@href='#/preference-card/physicians']";
	public static String DashBoard_Admin_approvals = "approvals#xpath=//a[@href='#/approvals']";
	public static String DashBoard_Admin_manufacturers = "manufacturers#xpath=//a[@href='#/admin/manufacturers']";
	public static String DashBoard_Admin_manufacturersFirst = "manufacturers_First#xpath=(//*[@class='grid-item-name grid-title-label-container'])[1]";
	public static String DashBoard_Admin_manufacturers_Searchbtn = "Searchbtn#xpath=//button[contains(text(),'Search')]";
	public static String DashBoard_Admin_glcode = "glcode#xpath=//a[@href='#/admin/glcode']";
	public static String DashBoard_Admin_pattern = "pattern#xpath=//a[@href='#/admin/pattern']";
	public static String DashBoard_Admin_ponumber = "ponumber#xpath=//a[@href='#/admin/ponumber']";
	public static String DashBoard_Admin_po_special_instructions = "po-special-instructions#xpath=//a[@href='#/po-special-instructions']";
	public static String DashBoard_Admin_invoicepaymentservice = "_invoicepaymentservice#xpath=//a[@href='#/invoice/payment-terms']";
	public static String DashBoard_Admin_news = "news#xpath=//a[@href='#/admin/news']";
	public static String DashBoard_Admin_vendor = "vendor#xpath=//a[@href='#/admin/vendor']";
	public static String DashBoard_Admin_vendoraccountsetup = "vendoraccountsetup#xpath=//a[@href='#/admin/vendoraccountsetup']";
	public static String DashBoard_Admin_pricetier = "pricetier#xpath=//a[@href='#/admin/pricetier']";
	public static String DashBoard_Admin_Search_Priority = "SearchPriority#xpath=//a[@href='#/vendors']";
	public static String DashBoard_Admin_DisplayPriority = "DisplayPriority</#xpath=//a[@href='#/vendors-sort']";
	public static String DashBoard_Admin_items_catalog = "items-catalog#xpath=//a[@href='#/items-catalog']";
	public static String DashBoard_Admin_inventory_locations = "inventory-locations#xpath=//a[@href='#/inventory-locations']";
	public static String DashBoard_Admin_inventory_item_transaction = "items_catalog#xpath=//a[@href='#/inventory/inventory-item-transaction']";
	public static String DashBoard_Admin_items_categories = "items-categories#xpath=//a[@href='#/inventory/item-categories']";
	public static String DashBoard_Admin_print_barcodes_qrcodes = "print-barcodes-qrcodes#xpath=//a[@href='#/inventory/print-barcodes-qrcodes']";
	public static String DashBoard_Admin_integration = "integration#xpath=//a[@href='#/integration']";
	public static String DashBoard_Admin_Hybrent_Apis = "Hybrent_Apis#xpath=//a[text()='Hybrent Apis']";
	
	// User Setting
		public static String Dashboard_User = "User#xpath=//*[@class='user-cont']";
		public static String Dashboard_User_Profile = "Profile#xpath=//a[@href='#/user/update-profile']";
		public static String Dashboard_User_NotificationSetting = "NotificationSetting#xpath=//*[@href='#/notification/settings']";
		public static String Dashboard_User_alert = "alert#xpath=//*[@href='#/user/update-profile/alert']";
		public static String Dashboard_User_Survey = "Survey#xpath=//a[text()='Survey']";
		public static String Dashboard_User_ChangePassword = "ChangePassword#xpath=//a[text()='Change Password']";
		public static String Dashboard_User_SwitchUser = "SwitchUser#xpath=//*[@href='#/selectuser']";
		// Profile
		public static String Dashboard_Profile_UserProdile = "UserProfile#xpath=//span[text()='User Profile']";
		public static String Dashboard_Profile_Btn_Update = "Btn_Update#xpath=//button[text()='Update']";
		public static String Dashboard_Profile_Btn_cancel = "Btn_Cancel#xpath=//*[@value='Cancel']";
		public static String Dashboard_Profile_Label_Name = "Label_Name#xpath=//*[@for='name']";
		public static String Dashboard_Profile_Label_Email = "Label_email#xpath=//*[@for='email']";
		public static String Dashboard_Profile_Input_Email = "input_email#xpath=//*[@id='email']";
		public static String Dashboard_Profile_Label_Email_Validation = "Validation_email#xpath=//*[@id='email']//following-sibling::p";
		public static String Dashboard_Profile_Label_phone = "Label_phone#xpath=//*[@for='phone']";
		public static String Dashboard_Profile_Label_Photo = "Label_Photo#xpath=//*[@for='pic']";
		public static String Dashboard_Profile_Label_Facility = "Label_Facility#xpath=//label[text()='Facility']";
		public static String Dashboard_Profile_Label_Dept = "Label_Dept#xpath=//label[text()='Department:']";
		public static String Dashboard_Profile_input_Facility = "input_Facility#xpath=(//*[@class='form-group']//*[@class='ng-binding'])[2]";
		public static String Dashboard_Profile_input_Dept = "input_Dept#xpath=(//*[@class='form-group']//*[@class='ng-binding'])[3]";
		public static String Dashboard_Profile_input_Inventory = "input_Inventory#xpath=(//*[@class='form-group']//*[@class='ng-binding'])[4]";
		public static String Dashboard_Profile_Label_Inventory = "Label_Inventory#xpath=//label[text()='Inventory']";
		public static String Dashboard_Profile_Label_Journeydate = "Label_Journeydate#xpath=//label[text()='Joining Date:']";
		public static String Dashboard_Profile_Label_QuickBook = "Label_QuickBook#xpath=//label[text()='Quick Books:']";
		public static String Dashboard_Profile_userEmail="userEmail#xpath=//*[@id='email']";
		public static String Dashboard_ActionDropdown="ActionDropdown#xpath=//*[@ng-if='showAppTourBtn']//button";
		public static String Dashboard_ActionDropdown_ShowTour="ShowTour#xpath=//a[text()='Show Tour']";
		public static String Dashboard_ShowTour_welcome="ShowTour_welcome#xpath=//*[@class='tour-step-content']/span";
		public static String Dashboard_ShowTour_Next="ShowTour_Next#xpath=//button[text()='Next »']";
		public static String Dashboard_ShowTour_EndTour="ShowTour_EndTour#xpath=(//button[text()='End tour'])[5]";
		public static String Dashboard_3Mb_validation="3Mb_validation#xpath=//*[@class='toast-message' and text()='Incorrect file or Exceeds the limit max 3 mb doc can be uploaded.']";
		
		// Alert
		public static String Dashboard_Alert_txt_userAlert = "txt_userAlert#xpath=//span[text()='User Alert']";
		public static String Dashboard_Alert_Btn_Update = "Btn_Update#xpath=//button[text()='Update']";
		public static String Dashboard_Alert_Btn_cancel = "Btn_Cancel#xpath=//*[@value='Cancel']";

	// Pagination 
		public static String Pagination_First = "FirstPage#xpath=//*[@role='menuitem']/a[text()='First']";
		public static String Pagination_Last = "LastPage#xpath=//*[@role='menuitem']/a[text()='Last']";
		public static String Pagination_ActivePage = "ActivePage#xpath=//*[@class='pagination-page ng-scope active']/a";
		
	
	// Dashboard - sub menu
	public static String Dashboard_Submenu_Dashboard ="submenuDashboard#xpath=//*[@ng-if='nav.noSubMenu' and @href='#/dashboard']";
	public static String Dashboard_Submenu_shop ="submenushop#xpath=//*[@ng-if='nav.noSubMenu' and @href='#/shop']";
	public static String Dashboard_Submenu_Orders ="submenuOrders#xpath=//*[@ng-if='nav.noSubMenu' and @href='#/orders']";
	public static String Dashboard_Submenu_Requestservices ="submenuRequestServices#xpath=//*[@ng-if='nav.noSubMenu' and @href='#/service-request/create']";
	public static String Dashboard_Submenu_OrderApprove ="submenuOrderApprove#xpath=//*[@ng-if='nav.noSubMenu' and @href='#/orders/approve']";
	public static String Dashboard_Submenu_Receive ="submenuReceive#xpath=//*[@ng-if='nav.noSubMenu' and @href='#/orders/receive']";
	public static String Dashboard_Submenu_shipments ="submenushipments#xpath=//*[@ng-if='nav.noSubMenu' and @href='#/orders/shipments']";
	public static String Dashboard_Submenu_invoice ="submenuinvoice#xpath=//*[@ng-if='nav.noSubMenu' and @href='#/invoice']";
	public static String Dashboard_Submenu_templates ="submenutemplates#xpath=//*[@ng-if='nav.noSubMenu' and @href='#/templates']";
	public static String Dashboard_Submenu_Scanout ="submenuScanout#xpath=//*[contains(text(),'Scan out')]";
	public static String Dashboard_Submenu_Manageinventory ="submenuManageinventory#xpath=//*[@ng-if='nav.noSubMenu' and @href='#/inventory']";
	public static String Dashboard_Submenu_Planner ="submenuPlanner#xpath=//*[@ng-if='nav.noSubMenu' and @href='#/preference-card/planner']";
	public static String Dashboard_Submenu_cases ="submenucases#xpath=//*[@ng-if='nav.noSubMenu' and @href='#/preference-card/cases']";
	public static String Dashboard_Submenu_patients ="submenupatients#xpath=//*[@ng-if='nav.noSubMenu' and @href='#/preference-card/patients']";
	public static String Dashboard_Submenu_procedures ="submenuprocedures#xpath=//*[@ng-if='nav.noSubMenu' and @href='#/preference-card/procedures']";
	public static String Dashboard_Submenu_Prederedcard ="submenuPereferedcard#xpath=//*[@ng-if='nav.noSubMenu' and @href='#/preference-card/cards']";
	public static String Dashboard_Submenu_operating_rooms ="submenuoperating_rooms#xpath=//*[@ng-if='nav.noSubMenu' and @href='#/preference-card/operating-rooms']";
	public static String Dashboard_Submenu_Report ="submenuReports#xpath=//*[@ng-if='nav.noSubMenu' and @href='#/reports/activity-report']";
	public static String Dashboard_Submenu_News ="submenuNews#xpath=//*[@ng-if='nav.noSubMenu' and @href='#/news']";
	// icon
	public static String Dashboard_Submenu_Dashboardicon ="iconDashboard#xpath=//*[@class='menu-icon dailydash']";
	public static String Dashboard_Submenu_shopicon ="iconshop#xpath=//*[@class='menu-icon shop']";
	public static String Dashboard_Submenu_Ordersicon ="iconOrders#xpath=//*[@class='menu-icon orders']";
	public static String Dashboard_Submenu_Requestservicesicon ="iconServices#xpath=//*[@class='menu-icon service']";
	public static String Dashboard_Submenu_OrderApproveicon ="iconOrderApprove#xpath=//*[@class='menu-icon approve']";
	public static String Dashboard_Submenu_Receiveicon ="iconsubmenuReceive#xpath=//*[@class='menu-icon receive']";
	public static String Dashboard_Submenu_shipmentsicon ="iconshipments#xpath=//*[@class='menu-icon shipment']";
	public static String Dashboard_Submenu_invoiceicon ="iconinvoice#xpath=//*[@class='menu-icon invoice']";
	public static String Dashboard_Submenu_templatesicon ="icontemplates#xpath=//*[@class='menu-icon template']";
	public static String Dashboard_Submenu_Scanouticon ="iconScanout#xpath=(//*[@class='menu-icon'])[1]";
	public static String Dashboard_Submenu_Manageinventoryicon ="iconManageinventory#xpath=//*[@class='menu-icon manage-inventory']";
	public static String Dashboard_Submenu_Plannericon ="iconPlanner#xpath=//*[@class='menu-icon fa-nav-icon']";
	public static String Dashboard_version ="version#xpath=//*[@class='version-container']";
	public static String Dashboard_PoweredBy ="PoweredBy#xpath=//*[text()='POWERED BY']";
	public static String Dashboard_HybrentLogo ="HybrentLogo#xpath=//img[@src='images/site-logos/hybrent-light.png']";
	public static String Dashboard_partialOrder ="PartialOrder#xpath=(//*[@ng-click='goToOrders()'])[1]";
	public static String Dashboard_Recent_Orders ="Recent_Orders#xpath=//*[@class='recent-head']//*[text()='Recent Orders']";
	public static String Dashboard_Recent_Orders5 ="Recent_Orders5#xpath=//*[@id='reqListing']//a";
	
	
	
	public static String Order_All ="Order_All#xpath=//*[@class='ui-select-choices-row-inner']//*[text()='All']";
	//Users Page
		public static String users_page="Users_page#xpath=//*[@href='#/admin/users']";
		public static String users_SearchByText="SearchByText#angular_model=searchFilter";
		public static String users_First_Changepassword="firstChangepassword#xpath=(//button[@ng-click='changePassword(adminUserData.id)'])[1]";
		public static String users_First_EditChangepassword="first_EditChangepassword#xpath=(//button[text()='Edit'])[1]";
		public static String users_changepassword_Pagination="changepassword_Pagination#angular_model=search.currentPage";
		public static String user_label_searchby="label_searchBy#xpath=//label[text()='Search by']";
		public static String user_label_Facility="label_Facility#xpath=//label[@for='search-facility']";
		public static String user_label_status="label_status#xpath=//label[@for='search-status']";
		public static String user_dropdown_status="dropdown_status#angular_model=searchActive";
		public static String user_dropdown_searchFacility="dropdown_Facility#angular_model=searchFacility";
		public static String user_Addbutton="AdduserBtn#xpath=//button[@ng-click='createUser()']";
		public static String user_Editbutton="AdduserBtn#xpath=//button[@ng-click='createUser()']";
		public static String user_top_Img="top_Img#xpath=//*[@class='user-img']";

	// User - Add User
		public static String user_add_usertab="tab_user#xpath=//*[@heading='User']/a";
		public static String user_add_userAccess="tab_useraccess#xpath=//*[@heading='User Access']/a";
		public static String user_add_itemCatalogAcess="tab_itemCatalogAcess#xpath=//*[@heading='Item Catalog Access']/a";
		public static String user_add_poalert="tab_poalert#xpath=//*[@heading='PO Alerts']/a";
		public static String user_add_facilityacess="tab_facilityacess#xpath=//*[@heading='Facility Access']/a";
		public static String user_add_Vendoraccess="tab_Vendoraccess#xpath=//*[@heading='Vendor Access']/a";
		public static String user_add_Notification ="tab_user#xpath=//*[@heading='Notification Access']/a";
		
		// User Add User - User
		public static String user_addUser_header ="Label_addUser#xpath=//*[contains(text(),'Add User')]";
		public static String user_addUser_User_LabelName ="Label_Name#xpath=//label[@for='name']";
		public static String user_addUser_User_LabelEmpno ="Label_Empno#xpath=//label[@for='employee_no']";
		public static String user_addUser_User_Labelnickname ="Label_nickname#xpath=//label[@for='nickname']";
		public static String user_addUser_User_Labelemail ="Label_email#xpath=//label[@for='email']";
		public static String user_addUser_User_Labelphone ="Label_phone#xpath=//label[@for='phone']";
		public static String user_addUser_User_Labelpassword ="Label_password#xpath=//label[@for='password']";
		public static String user_addUser_User_Labelcon_password ="Label_con_password#xpath=//label[@for='con_password']";
		public static String user_addUser_User_Labelfacility ="Label_facility#xpath=//label[@for='facility']";
		public static String user_addUser_User_Labeldepartment ="Label_department#xpath=//label[@for='department']";
		public static String user_addUser_User_Labelinventory ="Label_inventory#xpath=//label[@for='inventory']";
		public static String user_addUser_User_Labeljoining_date ="Label_joining_date#xpath=//label[@for='joining_date']";
		public static String user_addUser_User_Labelstatus ="Label_status#xpath=//label[@for='status']";
		public static String user_addUser_User_inputName ="txtbox_Name#angular_model=userFormData.name";
		public static String user_addUser_User_inputemployee_no ="txtbox_employee_no#angular_model=userFormData.employee_no";
		public static String user_addUser_User_inputnickname ="txtbox_nickname#angular_model=userFormData.nickname";
		public static String user_addUser_User_inputemail ="txtbox_email#angular_model=userFormData.email";
		public static String user_addUser_User_inputphone ="txtbox_Name#angular_phone=userFormData.phone";
		public static String user_addUser_User_inputpassword ="txtbox_password#angular_model=userFormData.password";
		public static String user_addUser_User_inputconfirmPass ="txtbox_confirmPass#angular_model=userFormData.confirmPass";
		public static String user_addUser_User_Addfacility ="plus_Addfacility#xpath=//button[@ng-click='addFacility();']";
		public static String user_addUser_User_addDepartment ="plus_addDepartment#xpath=//button[@ng-click='addDepartment();']";
		public static String user_addUser_User_addInventory ="plus_addInventory#xpath=//button[@ng-click='addInventory();']";
		
		// Add User - Add Facility - facility Details
		public static String user_addUser_Facility ="txt_addfaclity#xpath=//*[contains(text(),'Add Facility')]";
		public static String user_addUser_Facilitydetail_Organization ="label_Organization#xpath=//label[@for='organization']";
		public static String user_addUser_Facilitydetail_Mneonic ="label_mneonic#xpath=//label[@for='mnemonic']";
		public static String user_addUser_Facilitydetail_name ="label_name#xpath=//label[@for='name']";
		public static String user_addUser_Facilitydetail_licence ="label_licence#xpath=//label[@for='license_count']";
		public static String user_addUser_Facilitydetail_input_Mneonic ="input_Mneonic#angular_model=userFacilityData.mnemonic";
		public static String user_addUser_Facilitydetail_input_name ="input_name#angular_model=userFacilityData.name";
		public static String user_addUser_Facilitydetail_input_license_count ="input_license_count#angular_model=userFacilityData.license_count";
		public static String user_addUser_Facilitydetail_input_Facilityselect ="Facilityselect#angular_model=userFormData.facility_id";
		public static String user_addUser_Facilitydetail_input_department_idselect ="departmentSelect#angular_model=userFormData.department_id";
		public static String user_addUser_Facilitydetail_selec_inventory ="inventory#angular_model=userFormData.inventory_id";
		public static String user_addUser_Facilitydetail_save ="Facilitydetail_save#xpath=//*[@name='facility']//*[text()='Save']";
		public static String user_addUser_usertab ="userTab#xpath=//*[@heading='User']/a";
		// Add User - Add Facility - Shipping Address
		public static String user_addUser_ShippingAddress ="tab_shippingAddress#xpath=//*[@heading='Shipping Address']/a";
		public static String user_addUser_ShippingAddress_input_Address1 ="Address1#angular_model=userFacilityData.shipToAddress.address_line1";
		public static String user_addUser_ShippingAddress_input_Address2 ="Address2#angular_model=userFacilityData.shipToAddress.address_line2";
		public static String user_addUser_ShippingAddress_input_city ="city#angular_model=userFacilityData.shipToAddress.city";
		public static String user_addUser_ShippingAddress_input_state ="state#angular_model=userFacilityData.shipToAddress.state";
		public static String user_addUser_ShippingAddress_input_county ="county#angular_model=userFacilityData.shipToAddress.county";
		public static String user_addUser_ShippingAddress_input_postal_code ="postal_code#angular_model=userFacilityData.shipToAddress.postal_code";
		public static String user_addUser_ShippingAddress_input_country ="country#angular_model=userFacilityData.shipToAddress.country";
		
		//Add User - Add Facility - Invoice Address
		public static String user_addUser_InvoiceAddress ="tab_InvoiceAddress#xpath=//*[text()='Invoice Address']";
		public static String user_addUser_InvoiceAddress_input_Address1 ="Address1#angular_model=userFacilityData.invoiceAddress.address_line1";
		public static String user_addUser_InvoiceAddress_input_Address2 ="Address2#angular_model=userFacilityData.invoiceAddress.address_line2";
		public static String user_addUser_InvoiceAddress_input_city ="city#angular_model=userFacilityData.invoiceAddress.city";
		public static String user_addUser_InvoiceAddress_input_county ="county#angular_model=userFacilityData.invoiceAddress.county";
		public static String user_addUser_InvoiceAddress_input_state ="state#angular_model=userFacilityData.invoiceAddress.state";
		public static String user_addUser_InvoiceAddress_input_postal_code ="postal_code#angular_model=userFacilityData.invoiceAddress.postal_code";
		public static String user_addUser_InvoiceAddress_input_country ="country#angular_model=userFacilityData.invoiceAddress.country";
	
		//add user - add inventory
		public static String user_addUser_addinventorybtn ="addinventory#xpath=//button[@uib-tooltip='Add new Inventory']";
		public static String user_addUser_addinventory_title ="addinventoryTitel#xpath=//*[text()='Add Inventory Location']";
		public static String user_addUser_addinventory_Name ="addinventory_Name#angular_model=InventoryLocation.name";
		public static String user_addUser_addinventory_facilityselect ="facilityselect#angular_model=InventoryLocation.facility_id";
		public static String user_addUser_addinventory_facilitysave ="Save#xpath=//button[@ng-click='create(InventoryLocation)']";
		
		// Add User - Add department
		public static String user_addUser_AddDepartment ="AddDepartment#xpath=//button[@ng-click='addDepartment();']";
		public static String user_addUser_DepartmentTitle ="DepartmentTitle#xpath=//*[contains(text(),'Add Department')]";
		public static String user_addUser_addDepartment_facilityselect ="facilityselect#angular_model=departmentData.facility_id";
		public static String user_addUser_addDepartment_Mnemonic ="Mnemonic#angular_model=departmentData.mnemonic";
		public static String user_addUser_addDepartment_name ="name#angular_model=departmentData.name";
		public static String user_addUser_addDepartment_save ="btnSave#xpath=//*[@name='department']//button[text()='Save']";
		
		// Create User  - AddUserTab
		public static String user_addUser_tab ="addUserTab#xpath=//*[text()='User Access']";
		public static String user_addUser_label_canaccessadmin ="canaccessadmin#xpath=//label[text()='Can Access Admin']";
		public static String user_addUser_label_prefferedcardmanger ="prefferedcardmanger#xpath=//label[text()='Is Preference Card Manager']";
		public static String user_addUser_label_isvendorProfile ="isvendorProfile#xpath=//label[text()='Is Vendor Profile']";
		public static String user_addUser_label_canaccessbill ="canaccessbill#xpath=//label[text()='Can Approve Bill Only Items']";
		public static String user_addUser_label_resellerCustomer ="resellerCustomer#xpath=//label[text()='Is Reseller Customer']";
		public static String user_addUser_input_accesscustomer ="inputcanaccessadmin#xpath=//*[@for='can_access_admin']//following-sibling::div/div";
		public static String user_addUser_input_pref_card_manager ="pref_card_manager#xpath=//*[@for='is_pref_card_manager']//following-sibling::div/div";
		public static String user_addUser_input_Createpref_card_manager ="createpref_card_manager#xpath=//*[@for='can_create_pref_card']//following-sibling::div/div";
		public static String user_addUser_input_Editpref_card_manager ="Editpref_card_manager#xpath=//*[@for='can_edit_pref_card']//following-sibling::div/div";
		public static String user_addUser_input_Deletepref_card_manager ="Deletepref_card_manager#xpath=//*[@for='can_delete_pref_card']//following-sibling::div/div";
		public static String user_addUser_input_createprocedure ="createprocedure#xpath=//*[@for='can_create_procedure']//following-sibling::div/div";
		public static String user_addUser_input_Editprocedure ="Editprocedure#xpath=//*[@for='can_edit_procedure']//following-sibling::div/div";
		public static String user_addUser_input_Deleteprocedure ="Deleteprocedure#xpath=//*[@for='can_delete_procedure']//following-sibling::div/div";
		public static String user_addUser_input_vendor_representative ="input_vendor_representative#xpath=//*[@for='is_vendor_representative']//following-sibling::div/div";
		public static String user_addUser_input_approveBillonly ="approveBillonly#xpath=//*[@for='can_approve_bill_only_items']//following-sibling::div/div";
		public static String user_addUser_input_is_reseller ="is_reseller#xpath=//*[@for='is_reseller']//following-sibling::div/div";
		
		// Create User - Item Catalog Access
		public static String user_addUser_itemcatalogacess ="itemcatalogacess#xpath=//a[text()='Item Catalog Access']";
		public static String user_addUser_input_Additem ="input_Additem#xpath=//*[@for='can_add_item']//following-sibling::div/div";
		public static String user_addUser_input_Edititem ="input_Edititem#xpath=//*[@for='can_edit_item']//following-sibling::div/div";
		public static String user_addUser_input_Deleteitem ="input_Deleteitem#xpath=//*[@for='can_delete_item']//following-sibling::div/div";
		
		// Create User - Facility Access
		public static String user_addUser_FacilityAccess ="FacilityAccess#xpath=//a[text()='Facility Access']";
		public static String user_addUser_failityaccess_Select ="failityacessselect#angular_model=userFormData.facility_access";
		public static String user_addUser_failityaccess_facilityadd ="facilityadd#xpath=//button[@ng-click='facilityAccessAdd();']";
		public static String user_addUser_failityaccess_SelectAll="SeelctAll#angular_model=facilityCheckbox[facilityAccess.id]";
		
		// Create User - Vendor access
		public static String user_addUser_vendoraccess ="vendoraccess#xpath=//a[text()='Vendor Access']";
		public static String user_addUser_vendoraccess_selectventorlabel ="selectventorlabel#xpath=//label[contains(text(),'Select Vendors')]";
		public static String user_addUser_Addvendor ="Addvendor#xpath=//*[@class='item-menu-action']";
		public static String user_addUser_Addvendor_input ="InputAddvendor#xpath=//input[@id='itemslist']";
		public static String user_addUser_Addvendor_add ="Addvendor#xpath=(//*[@ng-click='selectItem(item.name,item.id)'])[1]";
		public static String user_addUser_Save ="Savebtn#xpath=//*[@name='user']//button[text()='Save']";
		
		// Change password
		public static String user_changepassword_Header ="changepassword_Header#xpath=//*[@class='headtext' and text()='Change Password']";
		public static String user_changepassword_msg ="changepassword_msg#xpath=//*[text()='You are logging in for the first time please change password to proceed.']";
		public static String user_changepassword_Label_oldPwd ="oldPwd#xpath=//label[@for='oldPassword']";
		public static String user_changepassword_Label_newPwd ="newPwd#xpath=//label[@for='newPassword']";
		public static String user_changepassword_Label_confirmPassword ="confirmPassword#xpath=//label[@for='confirmPassword']";
		public static String user_changepassword_Input_oldPwd ="oldPwd#xpath=//*[@id='oldPassword']";
		public static String user_changepassword_Input_newPwd ="newPwd#xpath=//*[@id='newPassword']";
		public static String user_changepassword_Input_confirmPassword ="confirmPassword#xpath=//*[@id='confirmPassword']";
		public static String user_changepassword_btnChangepassword ="btnChangepassword#xpath=//button[text()='Change Password']";
		public static String user_changepassword_sucesschanged ="sucesschanged#xpath=//h2[text()='Success']";
		public static String user_changepassword_ok ="ok#xpath=//button[text()='Ok']";
		// user Terms
		public static String user_Terms ="Terms#xpath=//*[@class='modal-title']//*[text()='Terms']";
		public static String user_Agree ="Agree#xpath=//button[@ng-click='termCtrl.agree(true)']";
		public static String user_disAgree ="disAgree#xpath=//button[@ng-click='termCtrl.disagree(false)']";
		public static String user_PrivacyPolicy ="PrivacyPolicy#xpath=//p[text()='Privacy Policy']";
		public static String user_TearmsService ="TearmsService#xpath=//*[text()='HYBRENT TERMS OF SERVICE']";
		public static String user_OpenSourceApplication ="OpenSourceApplication#xpath=//*[text()='Open source tools used in this application']";
		public static String user_readnotes_ok ="okaybtn#xpath=//button[@ng-click='readNote()']";
		public static String user_readnotes_GeneralImprovement ="GeneralImprovement#xpath=//*[text()='General Improvements']";
		
		
		// Reusable componet
		public static String Logout ="logout#xpath=//*[@class='logout' and last()]";
		public static String HeaderClose ="HeaderClose#xpath=//*[@class='headtext']//button[@class='close']";
		public static String Delete_Areyousure ="Delete_Areyousure#xpath=//h2[text()='Are you sure?']";
		public static String Delete_Confirm_Yes ="Delete_Yes#xpath=//button[@class='confirm' and text()='Yes']";
		public static String Delete_Confirm_Cancel ="Delete_Cancel#xpath=//button[@class='cancel' and text()='Cancel']";
		
		
		
		// Notification
		public static String Notification_Delete_Confirmation ="Delete_Confirmation#xpath=//p[text()='Are you sure you want to delete this notification?']";
		public static String Setting_Update_sucess ="Setting_Update_sucess#xpath=//*[text()='Setting Update']";
		
		
}

