/*
 * Copyright (C) 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * THIS FILE WAS GENERATED BY codergen. EDIT WITH CARE.
 */
package com.google.gapid.rpclib.any;

import com.google.gapid.rpclib.binary.*;
import com.google.gapid.rpclib.schema.*;

import java.io.IOException;

final class Float32Slice extends Box implements BinaryObject {
    @Override
    public Object unwrap() {
        return getValue();
    }

    //<<<Start:Java.ClassBody:1>>>
    private float[] mValue;

    // Constructs a default-initialized {@link Float32Slice}.
    public Float32Slice() {}


    public float[] getValue() {
        return mValue;
    }

    public Float32Slice setValue(float[] v) {
        mValue = v;
        return this;
    }

    @Override
    public BinaryClass klass() { return Klass.INSTANCE; }


    private static final Entity ENTITY = new Entity("any", "float32Slice", "", "");

    static {
        ENTITY.setFields(new Field[]{
            new Field("Value", new Slice("", new Primitive("float32", Method.Float32))),
        });
        Namespace.register(Klass.INSTANCE);
    }
    public static void register() {}
    //<<<End:Java.ClassBody:1>>>
    public enum Klass implements BinaryClass {
        //<<<Start:Java.KlassBody:2>>>
        INSTANCE;

        @Override
        public Entity entity() { return ENTITY; }

        @Override
        public BinaryObject create() { return new Float32Slice(); }

        @Override
        public void encode(Encoder e, BinaryObject obj) throws IOException {
            Float32Slice o = (Float32Slice)obj;
            e.uint32(o.mValue.length);
            for (int i = 0; i < o.mValue.length; i++) {
                e.float32(o.mValue[i]);
            }
        }

        @Override
        public void decode(Decoder d, BinaryObject obj) throws IOException {
            Float32Slice o = (Float32Slice)obj;
            o.mValue = new float[d.uint32()];
            for (int i = 0; i <o.mValue.length; i++) {
                o.mValue[i] = d.float32();
            }
        }
        //<<<End:Java.KlassBody:2>>>
    }
}
