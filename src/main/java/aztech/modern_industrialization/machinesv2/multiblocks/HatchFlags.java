/*
 * MIT License
 *
 * Copyright (c) 2020 Azercoco & Technici4n
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package aztech.modern_industrialization.machinesv2.multiblocks;

import aztech.modern_industrialization.machines.impl.multiblock.HatchType;

public class HatchFlags {
    private final int flags;

    public HatchFlags(int flags) {
        this.flags = flags;
    }

    public boolean allows(HatchType type) {
        return (flags & (1 << type.getId())) > 0;
    }

    public static class Builder {
        private int flags = 0;

        public Builder with(HatchType type) {
            flags |= 1 << type.getId();
            return this;
        }

        public Builder with(HatchType... types) {
            for (HatchType type : types) {
                with(type);
            }

            return this;
        }

        public HatchFlags build() {
            return new HatchFlags(flags);
        }
    }
}
