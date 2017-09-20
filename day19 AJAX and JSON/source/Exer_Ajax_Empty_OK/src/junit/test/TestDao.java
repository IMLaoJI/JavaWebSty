package junit.test;

import java.util.List;

import org.junit.Test;

import com.atguigu.bean.City;
import com.atguigu.bean.District;
import com.atguigu.bean.Province;
import com.atguigu.dao.CityDao;
import com.atguigu.dao.DistrictDao;
import com.atguigu.dao.ProvinceDao;

public class TestDao {
	
	private ProvinceDao provinceDao = new ProvinceDao();
	private CityDao cityDao = new CityDao();
	private DistrictDao districtDao = new DistrictDao();
	
	@Test
	public void test03(){
		//获取区县的信息
		List<District> list = districtDao.getListByCityId("4");
		
		for (District district : list) {
			System.out.println(district);
		}
	}
	
	@Test
	public void test02(){
		//获取城市的信息
		List<City> list = cityDao.getCityByProId("3");
		
		for (City city : list) {
			System.out.println(city);
		}
	}

	@Test
	public void test01() {
		//获取所有的省份的信息
		List<Province> list = provinceDao.getProvinceList();
		
		for (Province province : list) {
			System.out.println(province);
		}
	}

}
