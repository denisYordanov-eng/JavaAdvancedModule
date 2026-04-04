package military_elite;

import java.util.Set;

public interface ILeutenantGeneral extends IPrivate{
    Set<IPrivate> getPrivateImpls();
    void addPrivateImpl(IPrivate privateSoldier);
}
