package businessLayer.controllers;

import contract.Contract;
import contract.transferables.CustomerTransferable;

import java.util.List;

public class CustomerController implements EntityController<CustomerTransferable> {

    @Override
    public Contract<CustomerTransferable> getOne() {
        return null;
    }

    @Override
    public List<Contract<CustomerTransferable>> getMany() {
        return null;
    }

    @Override
    public boolean deleteOne() {
        return false;
    }

    @Override
    public boolean deleteMany() {
        return false;
    }

    @Override
    public boolean persist() {
        return false;
    }

    @Override
    public boolean update() {
        return false;
    }
}
