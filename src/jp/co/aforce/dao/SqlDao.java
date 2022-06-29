package jp.co.aforce.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.bean.ItemBean;
import jp.co.aforce.bean.ProductBean;
import jp.co.aforce.bean.UserBean;

public class SqlDao extends Dao{

//User


	//ログインを行うloginメソッド
	public UserBean login(UserBean bean) throws Exception{
		Connection con = getConnection();

		String sql = "select * from member_info where mail_address = ? and password = ?";

			PreparedStatement st = con.prepareStatement(sql);
			//変数sqlの一番目の?に引数のmail_addressをセットする
			st.setString(1, bean.getMail_address());
			//変数sqlの二番目の?に引数のpasswordをセットする
			st.setString(2, bean.getPassword());
			//sqlを実行し該当するデータ格納
			ResultSet rs = st.executeQuery();

			if(rs.next()) {
				// 見つかったアカウント情報を戻り値にセット
				bean.setMember_id(rs.getInt("member_id"));
				bean.setName(rs.getString("name"));
				bean.setMail_address(rs.getString("mail_address"));
				bean.setAddress(rs.getString("address"));
				bean.setPassword(rs.getString("password"));
			} else {
                // アカウントがなければnullを返す
                return null;
            }
			st.close();
			con.close();

		return bean;
	}

	//ユーザー検索を行うsearchメソッド
		public int search(UserBean bean)
				throws Exception{

				//DBに接続
				Connection con = getConnection();
				//SQL文の実行
				PreparedStatement st = con.prepareStatement( "select count(*) as record_count from member_info "
						+ "where name = ? and mail_address =? and address =? and password =?");
				//変数sqlの〇番目に引数をセットする
				st.setString(1, bean.getName());
				st.setString(2, bean.getMail_address());
				st.setString(3, bean.getAddress());
				st.setString(4, bean.getPassword());

				//sqlを実行し該当するデータ格納
				ResultSet rs = st.executeQuery();
				int count =0;

				while(rs.next()) {
					count=rs.getInt("record_count");
				}

				//DBからの切断
				st.close();
				con.close();

			return count;
		}


	//追加を行うinsertメソッド
	public int insert(UserBean bean) throws Exception {
		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
				"insert into member_info (name,mail_address,address,password)"
				+ "values(?,?,?,?)");
		//変数sqlの〇番目に引数をセットする
		st.setString(1,bean.getName());
		st.setString(2, bean.getMail_address());
		st.setString(3, bean.getAddress());
		st.setString(4, bean.getPassword());

		int new_member=st.executeUpdate();

		st.close();
		con.close();
		return new_member;
	}


	//更新を行うupdateメソッド
			public int update(UserBean bean) throws Exception {
				Connection con=getConnection();

				PreparedStatement st=con.prepareStatement(
						"update member_info set name = ?,mail_address = ?,address = ? where password=?");
				st.setString(1, bean.getName());
				st.setString(2, bean.getMail_address());
				st.setString(3, bean.getAddress());
				st.setString(4, bean.getPassword());

				int line=st.executeUpdate();

				st.close();
				con.close();
				return line;
			}

	//削除を行うdeleteメソッド
			public int delete(String password) throws Exception {
				Connection con = getConnection();

				PreparedStatement st=con.prepareStatement(
						"delete from member_info where password =?");

				st.setString(1, password);

				int line = st.executeUpdate();

				st.close();
				con.close();
				return line;
			}






//Product

		/*検索キーワードを使ってProductテーブルのname列をあいまい検索し、
		検索した結果をListにして返すメソッド*/
		public List<ProductBean> product_search(String keyword) throws Exception {
			List<ProductBean> list=new ArrayList<>();

			Connection con=getConnection();

			PreparedStatement st=con.prepareStatement(
					"select * from product_info where product_name like ?");
			st.setString(1, "%"+keyword+"%");
			ResultSet rs=st.executeQuery();

			//検索結果をProductBeanに格納してListに追加
			//
			while (rs.next()) {
				ProductBean bean =new ProductBean();
				bean.setProduct_id(rs.getInt("product_id"));
				bean.setProduct_name(rs.getString("product_name"));
				bean.setProduct_price(rs.getInt("product_price"));
				list.add(bean);
			}

			st.close();
			con.close();

			return list;
		}

		//価格の高い順で並べる
		public List<ProductBean> product_high(ProductBean bean) throws Exception {
			List<ProductBean> list=new ArrayList<>();

			Connection con=getConnection();

			PreparedStatement st=con.prepareStatement(
					"select * from product_info order by product_price desc");

			ResultSet rs=st.executeQuery();

			while (rs.next()) {
				ProductBean sort =new ProductBean();
				sort.setProduct_id(rs.getInt("product_id"));
				sort.setProduct_name(rs.getString("product_name"));
				sort.setProduct_price(rs.getInt("product_price"));
				list.add(sort);
			}

			st.close();
			con.close();

			return list;
		}

		//価格の低い順で並べる
		public List<ProductBean> product_low(ProductBean bean) throws Exception {
			List<ProductBean> list=new ArrayList<>();

			Connection con=getConnection();

			PreparedStatement st=con.prepareStatement(
					"select * from product_info order by product_price asc");

			ResultSet rs=st.executeQuery();

			while (rs.next()) {
				ProductBean sort =new ProductBean();
				sort.setProduct_id(rs.getInt("product_id"));
				sort.setProduct_name(rs.getString("product_name"));
				sort.setProduct_price(rs.getInt("product_price"));
				list.add(sort);
			}

			st.close();
			con.close();

			return list;
		}


		//商品検索を行うsearchメソッド
		public int product_search(ProductBean bean)
				throws Exception{

				//DBに接続
				Connection con = getConnection();
				//SQL文の実行
				PreparedStatement st = con.prepareStatement( "select count(*) as record_count from product_info "
						+ "where product_name = ? and product_price =?");
				//変数sqlの〇番目に引数をセットする
				st.setString(1, bean.getProduct_name());
				st.setInt(2, bean.getProduct_price());

				//sqlを実行し該当するデータ格納
				ResultSet rs = st.executeQuery();
				int count =0;

				while(rs.next()) {
					count=rs.getInt("record_count");
				}

				//DBからの切断
				st.close();
				con.close();

			return count;
		}


		//商品追加を行うinsertメソッド
		//ProductBeanの中身を取得して返す
		public int product_insert(ProductBean bean) throws Exception {
			Connection con=getConnection();

			PreparedStatement st=con.prepareStatement(
					"insert into product_info (product_name,product_price)"
					+ "values(?, ?)");
			st.setString(1, bean.getProduct_name());
			st.setInt(2, bean.getProduct_price());

			int line=st.executeUpdate();

			st.close();
			con.close();
			return line;
		}

		//商品更新を行うupdateメソッド
		public int product_update(ProductBean bean) throws Exception {
			Connection con=getConnection();

			PreparedStatement st=con.prepareStatement(
					"update product_info set product_name = ?,product_price = ? where product_id=?");
			st.setString(1, bean.getProduct_name());
			st.setInt(2, bean.getProduct_price());
			st.setInt(3, bean.getProduct_id());

			int line=st.executeUpdate();

			st.close();
			con.close();
			return line;
		}

		//商品削除を行うdeleteメソッド
		public int product_delete(int product_id) throws Exception {
			Connection con = getConnection();

			PreparedStatement st=con.prepareStatement(
					"delete from product_info where product_id =?");

			st.setInt(1, product_id);

			int line = st.executeUpdate();

			st.close();
			con.close();
			return line;
		}

		public int product_sum(int product_id) throws Exception{
			Connection con = getConnection();

			PreparedStatement st =con.prepareStatement(
			"select sum(product_price) from product_info where product_id = ?");

			st.setInt(1, product_id);

			int line=st.executeUpdate();

			st.close();
			con.close();
			return line;
		}
//Purchase
		public boolean purchase_insert(List<ItemBean> cart,String customer_payment) throws Exception {
			Connection con=getConnection();
			con.setAutoCommit(false);

			for (ItemBean item : cart) {
				PreparedStatement st=con.prepareStatement(
						"insert into order_info values(null, ?, ?, ?)");

				// 現在日時を取得
				LocalDateTime date = LocalDateTime.now();
				// 表示形式を指定
				DateTimeFormatter dtformat =
						DateTimeFormatter.ofPattern("yyyy/MM/dd/HH:mm");

				String fdate = dtformat.format(date);

				ProductBean product=item.getProduct();
				st.setInt(1, product.getProduct_id());
				st.setString(2, customer_payment);
				st.setString(3, fdate);
				int line=st.executeUpdate();
				st.close();

				if (line!=1) {
					con.rollback();
					con.setAutoCommit(true);
					st.close();
					return false;
				}
			}

				con.commit();
				con.setAutoCommit(true);
				con.close();
				return true;


			}

		//ToDo購入履歴を検索する
		public List<ProductBean> purchase_list(ProductBean bean) throws Exception {
			List<ProductBean> list=new ArrayList<>();

			Connection con=getConnection();

			PreparedStatement st=con.prepareStatement(
					"select * from order_info a inner join product_info b on a.product_id = b.product_id");

			ResultSet rs=st.executeQuery();

			while (rs.next()) {
				ProductBean history = new ProductBean();
				history.setProduct_id(rs.getInt("product_id"));
				history.setProduct_name(rs.getString("product_name"));
				history.setProduct_price(rs.getInt("product_price"));
				history.setOrder_date(rs.getString("order_date"));
				list.add(history);
			}

			st.close();
			con.close();

			return list;
		}

}