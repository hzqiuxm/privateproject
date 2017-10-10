package ziniuDesign.fd8_2.permitmgr.spi;


import ziniuDesign.fd8_2.permitmgr.sishuokspiimpl.SishuokSPIAbstractFactory;

public class SPIFactory<M> {
	public SPIAbstractFactory<M> createSPIAbstractFactory(){
		return new SishuokSPIAbstractFactory<M>();
	}
}
