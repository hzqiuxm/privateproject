package ziniuDesign.fd8_2.permitmgr.dispatch.base;

import ziniuDesign.fd8_2.permitmgr.spi.SPIFactory;
import ziniuDesign.fd8_2.permitmgr.spi.dispatch.DispatchDAO;

import java.util.List;

public abstract class BaseService<M> implements IService<M>{
	private DispatchDAO<M> dao = new SPIFactory<M>().createSPIAbstractFactory().createDispatchDAO();
	
	@Override
	public void create(M m) {
		dao.create(m);
	}

	@Override
	public void update(M m) {
		dao.update(m);
	}

	@Override
	public void delete(M m) {
		dao.delete(m);
	}

	@Override
	public M getById(int id) {
		return dao.getById(id);
	}

	@Override
	public List<M> getByCondition(M m, int begin, int pageSize) {
		return dao.getByCondition(m, begin, pageSize);
	}

}
