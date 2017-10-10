package ziniuDesign.fd8_2.permitmgr.spi;


import ziniuDesign.fd8_2.permitmgr.spi.dispatch.DispatchDAO;
import ziniuDesign.fd8_2.permitmgr.spi.validate.ValidateSPI;

public interface SPIAbstractFactory<M> {
	public DispatchDAO<M> createDispatchDAO();
	
	public ValidateSPI createValidateSPI();
}
