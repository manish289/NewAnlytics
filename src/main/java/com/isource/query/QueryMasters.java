package com.isource.query;

public final class QueryMasters {

	// Authority Repository
	public static String organization_getall = "select * from organization_getall()";
	public static String organization_type_getall = "select * from organization_type_getall()";


	// Common Repository
	public static String keyword_getall = "select * from keyword_getall()";
	public static String product_getall = "select * from product_getall()";
	public static String industry_getall = "select * from industry_getall()";
	public static String sub_industry_getall = "select * from sub_industry_getall()";
	public static String bidder_getall = "select * from bidder_getall()";
	public static String result_stage_master_getall = "select * from result_stage_master_getall()";

	// User Repository
	public static String user_login = "select * from user_login(?,?,?)";
	public static String change_password = "select * from change_password(?,?,?)";
	public static String insert_user_profile = "insert into user_profile (user_id,subscribe_category,subscription_duration,last_date_of_subscription,subscription_amount,tax_invoice,key_manager_details) values (?,?,?,?,?,?,?)";
	public static String insert_user_profile_harsh = "select * from user_profile_insert(?,?,?,?,?,?,?)";
	public static String user_profile_detail="select * from user_profile_detail(?)";
	public static String user_bidder_getall = "select * from user_bidders_getall()";

	// Location Repository
	public static String city_getall = "select * from city_getall()";
	public static String state_getall = "select * from state_getall()";
	public static String region_getall = "select * from region_getall()";

	// WatchList Repository
	public static String watchlist_getall = "select * from watchlist_getall()";
	public static String watch_list_delete = "select * from watchlist_delete(?,?)";
	public static String watchlist_insert = "select * from watchlist_insert (?,?,?)";

	// Dash Board Repository
	public static String dashboard_bidder_top_competitors_monthwise_list = "select * from dashboard_bidder_top_competitors_monthwise_list(?,?,?)";
	public static String dashboard_bidder_top_competitors_list = "select * from dashboard_bidder_top_competitors_list(?,?,?)";
	public static String dashboard_publish_tender_state_wise = "select * from dashboard_publish_tender_state_wise(?,?,?)";
	public static String dashboard_tendering_ownership = "select * from dashboard_tendering_ownership(?,?,?)";
	public static String dashboard_statistics_getall = "select * from dashboard_get_statistics(?,?,?)";
	public static String dashboard_list_of_top_competitors_list = "select * from dashboard_list_of_top_competitors_list(?)";

	// Result Repository
	public static String result_analytics_detail = "select * from result_analytics_detail(?)";
	public static String get_bidder_participated_result = "select * from get_bidder_participated_result(?,?,?)";
	public static String get_related_keyword_from_result_id = "select * from get_related_keyword_from_result_id(?)";
	public static String result_analytics_document_detail = "select * from result_analytics_document_detail(?)";
	public static String get_similar_result_by_result_id = "select * from get_similar_result_by_result_id(?)";
	public static String get_similar_result = "select * from get_similar_result(?,?,?,?,?)";
	public static String result_analytics_search="select * from result_analytics_search(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String get_participating_bidder="select * from participating_bidder_by_resultid(?)";
	public static String insert_fav_tender = "select * from insert_delete_favorite_result (?,?,?)";
	public static String result_analytics_sitelocation_detail = "select * from result_analytics_sitelocation_detail(?)";
	
	// Competitor Repository
	public static String competitor_get_general_competitors_list = "select * from competitor_get_general_competitors_list(?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String competitor_get_top_competitors_list = "select * from competitor_get_top_competitors_list(?,?,?,?,?,?,?)";
	public static String competitor_get_top_competitors_list_chart = "select * from competitor_get_top_competitors_list_chart(?,?,?,?,?,?,?,?)";
	public static String shorlisted_competitors_list = "select * from shorlist_competitors_list(?,?)";
	public static String shorlist_competitors_list_monthwise = "select * from shorlist_competitors_list_monthwise(?,?,?)";
	
	//Company Profile Repository
	public static String company_profile_dashboard_statistics = "select * from company_profile_dashboard_statistics(?,?,?)";
	public static String company_profile_tender_state_wise = "select * from dashboard_publish_tender_state_wise(?,?,?)";
	public static String company_profile_tendering_ownership = "select * from dashboard_tendering_ownership(?,?,?)";
	public static String company_profile_month_wise = "select * from company_profile_month_wise(?,?,?)";
	public static String company_profile_department = "select * from company_profile_department(?,?,?);";
	public static String company_profile_tender_stages = "select * from company_profile_tender_stages(?,?,?);";
	public static String company_profile_monthwise_tenders = "select * from company_profile_monthwise_tenders(?,?,?);";
	
	// compare company
	public static String compare_individual_comparision = "select * from compare_individual_comparision(?,?,?,?,?)";
	public static String compare_tender_ownership = "select * from compare_tender_ownership(?,?,?,?,?)";
	public static String compare_tender_statewise = "select * from compare_tender_statewise(?,?,?,?,?)";
	public static String compare_strong_points_department_wise = "select * from compare_strong_points_department_wise(?,?,?,?,?)";
	public static String compare_strong_points_ownership_wise = "select * from compare_strong_points_ownership_wise(?,?,?,?,?)";
	public static String compare_strong_points_state_wise = "select * from compare_strong_points_state_wise(?,?,?,?,?)";
	public static String compare_same_bid = "select * from compare_same_bid_comparison(?,?,?)";
	public static String compare_same_bid_comparision_state_wise = "select * from compare_same_bid_comparision_state_wise(?,?,?,?,?)";
	public static String compare_company_name = "select * from compare_companies_name_list(?)";

}