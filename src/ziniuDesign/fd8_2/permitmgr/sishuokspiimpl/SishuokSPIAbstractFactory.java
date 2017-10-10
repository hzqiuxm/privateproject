package ziniuDesign.fd8_2.permitmgr.sishuokspiimpl;


import ziniuDesign.fd8_2.permitmgr.spi.SPIAbstractFactory;
import ziniuDesign.fd8_2.permitmgr.spi.dispatch.DispatchDAO;
import ziniuDesign.fd8_2.permitmgr.spi.validate.ValidateSPI;

public class SishuokSPIAbstractFactory<M> implements SPIAbstractFactory<M> {

	@Override
	public DispatchDAO<M> createDispatchDAO() {
		return new SishuokDispatchDAOImpl<M>();
	}

	@Override
	public ValidateSPI createValidateSPI() {
		return new SishuokValidateSPIImpl();
	}

}
