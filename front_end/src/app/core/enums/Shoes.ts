import {TypeSex} from './TypeSex';
import {Discipline} from './Discipline';
import {Trademark} from './Trademark';
import {SurfaceArea} from './SurfaceArea';

export interface Shoes {
    id: number,
    name: string,
    sex: TypeSex,
    price: number,
    minSize: number,
    maxSize: number,
    link: string,
    discipline: Discipline,
    trademark: Trademark,
    surfacearea: SurfaceArea
}
