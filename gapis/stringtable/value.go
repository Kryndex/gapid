// Copyright (C) 2017 Google Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package stringtable

import (
	"fmt"

	"github.com/google/gapid/gapis/service/path"
	"github.com/google/gapid/gapis/service/pod"
)

// ToValue returns v boxed in a Value.
func ToValue(v interface{}) *Value {
	switch v := v.(type) {
	case *path.Any:
		return &Value{&Value_Path{Path: v}}
	default:
		if val := pod.NewValue(v); val != nil {
			return &Value{&Value_Pod{Pod: val}}
		}
		panic(fmt.Errorf("Unsupported value type %T", v))
	}
}

// Unpack returns the underlying value wrapped by the Value.
func (v Value) Unpack() interface{} {
	switch v := v.Value.(type) {
	case *Value_Pod:
		return v.Pod.Get()
	case *Value_Path:
		return v.Path
	default:
		panic(fmt.Errorf("Unsupported value type %T", v))
	}
}
