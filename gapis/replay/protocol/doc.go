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

// Package protocol contains the constants and types used to communicate with
// the replay system and its virtual-machine interpreter.
//
// Any changes to the values in this package must also be made to the replay
// source.
package protocol

// The following are the imports that generated source files pull in when present
// Having these here helps out tools that can't cope with missing dependancies
import (
	_ "github.com/golang/protobuf/proto"
	_ "github.com/google/gapid/core/data/id"
	_ "github.com/google/gapid/core/data/pod"
	_ "github.com/google/gapid/framework/binary/registry"
	_ "github.com/google/gapid/framework/binary/schema"
)
