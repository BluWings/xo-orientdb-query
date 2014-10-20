package com.smbtec.xo.orientdb.query.gremlin;

import com.buschmais.xo.spi.datastore.Datastore;
import com.buschmais.xo.spi.datastore.DatastoreQuery;
import com.buschmais.xo.spi.datastore.DatastoreSession;
import com.buschmais.xo.spi.plugin.QueryLanguagePlugin;
import com.smbtec.xo.orientdb.api.OrientDbDatastoreSession;
import com.smbtec.xo.orientdb.impl.OrientDbDatastore;
import com.smbtec.xo.tinkerpop.blueprints.api.annotation.Gremlin;

public class GremlinQueryPlugin implements QueryLanguagePlugin<Gremlin> {

	public Class<Gremlin> init(final Datastore datastore) {
		if (datastore instanceof OrientDbDatastore) {
			return Gremlin.class;
		} else {
			return null;
		}
	}

	public DatastoreQuery<Gremlin> createQuery(final DatastoreSession session) {
		return new OrientDbGremlinQuery((OrientDbDatastoreSession) session);
	}

}
