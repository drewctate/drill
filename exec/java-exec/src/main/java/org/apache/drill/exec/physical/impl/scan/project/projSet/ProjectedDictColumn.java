/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.drill.exec.physical.impl.scan.project.projSet;

import org.apache.drill.exec.physical.resultSet.ProjectionSet;
import org.apache.drill.exec.physical.resultSet.project.ProjectionType;
import org.apache.drill.exec.physical.resultSet.project.RequestedTuple;
import org.apache.drill.exec.record.metadata.ColumnMetadata;

public class ProjectedDictColumn extends ProjectedReadColumn {

  private final ProjectionSet tupleProjection;

  public ProjectedDictColumn(ColumnMetadata readSchema,
                            RequestedTuple.RequestedColumn requestedCol, ColumnMetadata outputSchema,
                            ProjectionSet tupleProjection) {
    super(readSchema, requestedCol, outputSchema, null);
    this.tupleProjection = tupleProjection;
  }

  @Override
  public ProjectionSet mapProjection() {
    return tupleProjection;
  }

  @Override
  public ProjectionType projectionType() {
    return super.projectionType().isArray() ? ProjectionType.DICT_ARRAY : ProjectionType.ARRAY;
  }
}
