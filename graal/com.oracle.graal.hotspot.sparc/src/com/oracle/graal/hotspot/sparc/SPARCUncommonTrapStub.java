/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package com.oracle.graal.hotspot.sparc;

import static jdk.vm.ci.sparc.SPARC.g1;
import static jdk.vm.ci.sparc.SPARC.g3;
import static jdk.vm.ci.sparc.SPARC.g4;
import static jdk.vm.ci.sparc.SPARC.g5;
import static jdk.vm.ci.sparc.SPARC.o0;
import static jdk.vm.ci.sparc.SPARC.o1;
import static jdk.vm.ci.sparc.SPARC.o2;
import static jdk.vm.ci.sparc.SPARC.o3;
import static jdk.vm.ci.sparc.SPARC.o4;
import jdk.vm.ci.code.Register;
import jdk.vm.ci.code.RegisterConfig;
import jdk.vm.ci.code.TargetDescription;
import jdk.vm.ci.hotspot.HotSpotVMConfig;
import jdk.vm.ci.hotspot.sparc.SPARCHotSpotRegisterConfig;

import com.oracle.graal.hotspot.HotSpotForeignCallLinkage;
import com.oracle.graal.hotspot.meta.HotSpotProviders;
import com.oracle.graal.hotspot.stubs.UncommonTrapStub;

final class SPARCUncommonTrapStub extends UncommonTrapStub {

    private RegisterConfig registerConfig;

    public SPARCUncommonTrapStub(HotSpotProviders providers, TargetDescription target, HotSpotForeignCallLinkage linkage, HotSpotVMConfig config) {
        super(providers, target, linkage);
        // This is basically the maximum we can spare. All other G and O register are used.
        Register[] allocatable = new Register[]{g1, g3, g4, g5, o0, o1, o2, o3, o4};
        registerConfig = new SPARCHotSpotRegisterConfig(target.arch, allocatable, config);
    }

    @Override
    public RegisterConfig getRegisterConfig() {
        return registerConfig;
    }

}
