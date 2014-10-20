package com.smbtec.xo.orientdb.query.gremlin;

import java.util.HashMap;
import java.util.Map;

import com.buschmais.xo.spi.datastore.DatastoreQuery;
import com.smbtec.xo.orientdb.api.OrientDbDatastoreSession;
import com.smbtec.xo.tinkerpop.blueprints.api.annotation.Gremlin;
import com.smbtec.xo.tinkerpop.blueprints.impl.GremlinQuery;
import com.tinkerpop.blueprints.impls.orient.OrientEdge;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import com.tinkerpop.blueprints.impls.orient.OrientVertex;

public class OrientDbGremlinQuery extends GremlinQuery implements DatastoreQuery<Gremlin> {

    public OrientDbGremlinQuery(OrientDbDatastoreSession<OrientGraph> session) {
        super(session.getGraph());
    }

    @Override
    public Map<String, Object> entityRepresentation(Object entity) {
        Map<String, Object> result = new HashMap<>();
        if (entity instanceof OrientVertex) {
            result.put(NODE_COLUMN_NAME, (OrientVertex) entity);
            return result;
        } else if (entity instanceof OrientEdge) {
            result.put(EDGE_COLUMN_NAME, (OrientEdge) entity);
            return result;
        } else if (entity instanceof OrientGraph) {
            result.put(GRAPH_COLUMN_NAME, ((OrientGraph) entity).getRawGraph().toString());
            return result;
        } else {
            return super.entityRepresentation(entity);
        }
    }
}
