package mctech.h.b.c;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/b/c/b.class */
public class b implements a {
    @Override // mctech.h.b.c.a
    public Map<String, JsonElement> a(File file) {
        HashMap map = new HashMap();
        CommentedFileConfig commentedFileConfigBuild = CommentedFileConfig.builder(file).build();
        commentedFileConfigBuild.load();
        for (Map.Entry entry : commentedFileConfigBuild.valueMap().entrySet()) {
            map.put((String) entry.getKey(), new Gson().toJsonTree(entry.getValue()));
        }
        return map;
    }
}
