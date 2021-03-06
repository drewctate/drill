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
package org.apache.drill.metastore.iceberg;

import org.apache.drill.metastore.iceberg.operate.ExpirationHandler;
import org.apache.drill.metastore.iceberg.transform.Transformer;
import org.apache.drill.metastore.iceberg.write.FileWriter;
import org.apache.iceberg.Table;

/**
 * Provides Iceberg Metastore component tools to transform, read or write data from / in Iceberg table.
 *
 * @param <T> Metastore component unit type
 */
public interface MetastoreContext<T> {

  /**
   * Returns Iceberg table implementation used as storage for Metastore component data.
   *
   * @return Iceberg table instance
   */
  Table table();

  /**
   * Returns file writer which stores Metastore component data in the format
   * supported by the {@link FileWriter} implementation.
   *
   * @return file writer instance
   */
  FileWriter fileWriter();

  /**
   * Returns transformer instance that provides tools to
   * transform filters, operations and data.
   *
   * @return transformer instance
   */
  Transformer<T> transformer();

  /**
   * Returns expiration handler that expires Iceberg table metadata.
   *
   * @return expiration handler instance
   */
  ExpirationHandler expirationHandler();
}
