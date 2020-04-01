package businessLayer.controllers;

import contract.Contract;
import contract.transferables.BankTransferable;
import contract.transferables.TransactionTransferable;

import java.util.List;

public class TransactionController implements EntityController<TransactionTransferable>{

    @Override
    public Contract<TransactionTransferable> getOne() {
        return null;
    }

    @Override
    public List<Contract<TransactionTransferable>> getMany() {
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
