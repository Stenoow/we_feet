import {TypeSex} from './TypeSex';

export interface Shoes {
    id: number,
    name: string,
    sex: TypeSex,
    price: number,
    minSize: number,
    maxSize: number,
    link: string,
    disciplineId: number,
    trademarkId: number,
    surfaceareaId: number
}
