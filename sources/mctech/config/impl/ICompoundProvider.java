package mctech.config.impl;

import mctech.config.utils.ParseResult;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/impl/ICompoundProvider.class */
public interface ICompoundProvider {
    ParseResult<Boolean> isValid(String str, int i);
}
