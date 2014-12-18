import br.com.etyllica.EtyllicaFrame;
import br.com.etyllica.context.Application;
import br.com.etyllica.ipfun.IPV4Application;
import br.com.etyllica.util.PathHelper;


public class IPFun extends EtyllicaFrame {

	private static final long serialVersionUID = 1L;

	public IPFun() {
		super(1024, 768);
	}
	
	public static void main(String[] args) {
		IPFun app = new IPFun();
		app.init();
	}	

	@Override
	public Application startApplication() {

		String path = PathHelper.currentDirectory();
		
		setPath(path+"../../../");
		
		return new IPV4Application(w, h);		
	}

}
