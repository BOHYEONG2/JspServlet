package kr.ac.kopo.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class HandlerMapping {
	
	private Map<String, Controller> mappings;
	
	public HandlerMapping() {   // 왜 이걸 생성자 안에 new한다 하셧지 >> 계속 초기화 
		mappings = new HashMap<>(); 
		Properties prop = new Properties();
		
		try {
			InputStream is = new FileInputStream("C:\\Users\\User\\eclipse-workspaceJSP\\MyBanking\\bean.properties");  // 왼쪽 파일에 들어가면 properties있음 
			prop.load(is); 
	
			Set<Object> keys = prop.keySet();
			for(Object key : keys) {
				System.out.println(key);
				String className = prop.getProperty(key.toString());    // key가 오브젝트형으로 되어있고 property는 String형이니 toString
				System.out.println(key + " : " + className); 
				
				Class<?> clz = Class.forName(className);
				Constructor<?> constructor = clz.getConstructor();
				
			//	mappings.put(key, constructor.newInstance());  // 이건 오브젝트형인데 우린 컨트롤러 형으로 만들어서 에러 안나려면 명시적 형변환 해줘야함
				mappings.put(key.toString(), (Controller)constructor.newInstance()); 
		}
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	
	
	}

	
	public Controller getController(String uri) {
		return mappings.get(uri);		
	}
		
		
}
/*		
		public static void main(String[] args) throws Exception {
//			java.util.Random r = new java.util.Random();
//			System.out.println(r.nextInt());
			
			Class<?> clz = Class.forName("java.util.Random");
			// 어떤값을 받을지 모르니 모든걸 받겠다는 뜻으로 ? 를 썼음 그걸 와일드카드라고 부름 ***와일드카드 타입은 모든 타입을 읽는다***
			//1.클래스 내용을 가져오고 
			
		    //Object obj = clz.newInstance();  Constructor은 생성자 클래스
			Constructor<?> constructor = clz.getConstructor();
			//2.생성자를 만들고
			Object obj = constructor.newInstance();
			//3. 인스턴스 객체를 만든다
			
			System.out.println("난수 : " + ((java.util.Random)obj).nextInt());
			
	}

}
*/
